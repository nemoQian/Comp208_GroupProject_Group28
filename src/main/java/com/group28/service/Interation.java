package com.group28.service;

import com.group28.dao.ElectricityUnitDao;
import com.group28.dao.PowerStationDao;
import com.group28.pojo.*;
import com.group28.util.MyBatisUtil;
import com.group28.util.SimulateVirtualWorld;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Interation implements IntegrationInterface{

    private final int FAIL = -1;
    private final int SUCCESS = 1;
    private final int ROW = 0;
    private final int COL = 1;

    private int state = 0;

    private static final String[] electricityUnitTypeName = {"Community", "Hospital", "Shopping centre", "School"};
    private final String powerStationTypeName = "Power station";

    private final String[] communityType = {"COL","COM","COH"};
    private final String[] schoolType = {"SCL","SCM","SCH"};
    private final String[] hospitalType = {"HOL","HOM","HOH"};
    private final String[] shoppingCentreType = {"SHL","SHM","SHH"};
    private final String[] powerStationType = {"PSL","PSM","PSH"};

    private HashMap<String, String[]> typeMapper;
    private HashMap<String, Integer> levelMapper;

    private ElectricityUnit electricityUnit;
    private PowerStation powerStation;
    private FacilityData facilityData;

    private int numberOfPowerStation = 0;
    private int numberOfElectricity = 0;

    private SimulateVirtualWorld virtualWorld;

    public Interation(){
        resetDB();
        typeMapper = new HashMap<String, String[]>();
        levelMapper = new HashMap<String, Integer>();
        typeMapper.put("Community", communityType);
        typeMapper.put("Hospital", hospitalType);
        typeMapper.put("Shopping centre", shoppingCentreType);
        typeMapper.put("School", schoolType);
        levelMapper.put("low-level",0);
        levelMapper.put("medium-level",1);
        levelMapper.put("high-level",2);
        virtualWorld = new SimulateVirtualWorld();
    }

    @Override
    public int[] worldSimulationOpen(){
        if(virtualWorld.judgement()){
            virtualWorld.worldSimulateOpen();
            return new int[]{1};
        }
        else { return new int[]{-1}; }
    }

    @Override
    public int worldSimulationReset() {
        resetDB();
        virtualWorld.worldSimulateStop();
        virtualWorld.restWorld();
        virtualWorld.shutdownThreat();
        virtualWorld = new SimulateVirtualWorld();
        return SUCCESS;
    }

    public void resetDB(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PowerStationDao mapper1 = sqlSession.getMapper(PowerStationDao.class);
        List<String> powerStationList = mapper1.GetStationList();
        for(String id : powerStationList){
            mapper1.DeleteStation(id);
        }
        sqlSession.commit();

        ElectricityUnitDao mapper2 = sqlSession.getMapper(ElectricityUnitDao.class);
        List<String> electricityUnitList = mapper2.GetUnitIdList();
        for (String id : electricityUnitList) {
            mapper2.DeleteElectricityUnit(id);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public int addNewFacility(String facilityType, String facilityName, int locationX, int locationY, String facilityLevel) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        int[] location = {locationX, locationY};

        if (facilityType.equals(powerStationTypeName)){
            PowerStationDao mapper = sqlSession.getMapper(PowerStationDao.class);
            if(mapper.findPowerStation(facilityName) == null){
                generatePowerStation(facilityName,facilityLevel,location[ROW],location[COL]);
                facilityData = new FacilityData(powerStation, mapper.findPowerStationType(powerStationType[levelMapper.get(facilityLevel)]),facilityType);
                state =  virtualWorld.addNewFacility(facilityData, location);
                if(state == 1){
                    mapper.AddStation(powerStation);
                    sqlSession.commit();
                    sqlSession.close();
                    return SUCCESS;
                }
                else {
                    sqlSession.close();
                    return FAIL;
                }
            }
            else {
                sqlSession.close();
                return FAIL;
            }
        }
        else if (facilityType.equals(electricityUnitTypeName[0]) || facilityType.equals(electricityUnitTypeName[1]) ||
                 facilityType.equals(electricityUnitTypeName[2]) || facilityType.equals(electricityUnitTypeName[3])){
            ElectricityUnitDao mapper = sqlSession.getMapper(ElectricityUnitDao.class);
            if(mapper.findElectricityUnit(facilityName) == null){
                generateElectricityUnit(facilityType,facilityName,facilityLevel,location[ROW],location[COL]);
                facilityData = new FacilityData(electricityUnit,
                                                mapper.findElectricityUnitType(typeMapper.get(facilityType)[levelMapper.get(facilityLevel)]),
                                                facilityType);
                state =  virtualWorld.addNewFacility(facilityData, location);
                if(state == 1){
                    mapper.AddFacility(electricityUnit);
                    sqlSession.commit();
                    sqlSession.close();
                    return SUCCESS;
                }
                else {
                    sqlSession.close();
                    return FAIL;
                }
            }
            else {
                sqlSession.close();
                return FAIL;
            }
        }

        else { return FAIL; }
    }

    @Override
    public int getTotalConsumption() {
        return virtualWorld.getTotalConsumption();
    }

    @Override
    public int getTotalProduction() {
        return virtualWorld.getTotalProduction();
    }

    @Override
    public int getElectricityUnitConsumption(String electricityUnitName) {
        return 0;
    }

    @Override
    public int getPowerStationProduction(String powerStationName) {
        return 0;
    }

    @Override
    public int getTypicalTypeConsumption(String electricityUnitType) {
        return 0;
    }

    @Override
    public int getRateOfTypicalType(String electricityUnitType) {
        return 0;
    }

    public int getTotalBestLoss() { return virtualWorld.getTotalBestLose(); }

    public int getTotalWorstLoss() { return virtualWorld.getTotalWorstLose(); }

    private String generateZipCode(int x, int y) {
        if(x < 10){
            if( y < 10){
                return "S0" + x + " A0" + y;
            }
            else { return "S0" + x + " A" + y; }
        }
        else {
            if (y < 10) {
                return "S" + x + " A0" + y;
            } else {
                return "S" + x + " A" + y;
            }
        }
    }

    private String generateId(String powerStationType, int x, int y){
        if(x < 10){
            if( y < 10){
                return powerStationType + "S0" + x + "A0" + y;
            }
            else { return powerStationType + "S0" + x + "A" + y; }
        }
        else {
            if (y < 10) {
                return powerStationType + "S" + x + "A0" + y;
            } else {
                return powerStationType + "S" + x + "A" + y;
            }
        }
    }

    private void generatePowerStation(String powerStationName, String powerStationLevel, int x, int y){
        powerStation = new PowerStation();
        powerStation.Put_powerStationId(generateId(powerStationType[levelMapper.get(powerStationLevel)],x,y));
        powerStation.Put_zipCode(generateZipCode((x-38)/50+1,(y-15)/50));
        powerStation.Put_powerStationType(powerStationType[levelMapper.get(powerStationLevel)]);
        powerStation.Put_powerStationName(powerStationName);
    }

    private void generateElectricityUnit(String typeName, String electricityUnitName, String electricityUnitLevel, int x, int y){
        electricityUnit = new ElectricityUnit();
        electricityUnit.Put_electricityUnitId(generateId(typeMapper.get(typeName)[levelMapper.get(electricityUnitLevel)],x,y));
        electricityUnit.Put_zipCode(generateZipCode((x-38)/50+1,(y-15)/50));
        electricityUnit.Put_electricityUnitType(typeMapper.get(typeName)[levelMapper.get(electricityUnitLevel)]);
        electricityUnit.Put_electricityUnitName(electricityUnitName);
    }

    public int[] prim(){
        return virtualWorld.prim();
    }

    public int getLose(){
        return virtualWorld.getTotalLose();
    }

    public int getCurrentConsumption(){ return virtualWorld.getCurrentConsumption(); }

    public int getCurrentProduction(){ return virtualWorld.getCurrentProduction(); }

    public String getTime(){ return virtualWorld.getTime(); }

    public ArrayList<ArrayList<Integer>> getHeightList(){
        return virtualWorld.getHeightList();
    }

    public int[] getFanChart(){
        return virtualWorld.getFanChart();
    }

    public int[] getLineChart() { return virtualWorld.getLineChart(); }
}
