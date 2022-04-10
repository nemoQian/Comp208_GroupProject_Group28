package com.group28.service;

import com.group28.dao.ElectricityUnitDao;
import com.group28.dao.PowerStationDao;
import com.group28.pojo.*;
import com.group28.util.MyBatisUtil;
import com.group28.util.SimulateVirtualWorld;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Interation implements IntegrationInterface{

    private final int FAIL = -1;
    private final int SUCCESS = 1;
    private final int ROW = 0;
    private final int COL = 1;

    private int state = 0;

    private final String[] electricityUnitTypeName = {"Community", "Hospital", "ShoppingMall", "School"};
    private final String powerStationTypeName = "PowerStation";

    private ElectricityUnit electricityUnit;
    private PowerStation powerStation;
    private FacilityData facilityData;

    private int numberOfPowerStation = 0;
    private int numberOfElectricity = 0;

    private SimulateVirtualWorld virtualWorld;

    public Interation(){

    }

    @Override
    public int worldSimulationOpen(){
        resetDB();
        virtualWorld = new SimulateVirtualWorld();
        if(virtualWorld.judgement()){
            virtualWorld.worldSimulateOpen();
            return SUCCESS;
        }
        else { return FAIL; }
    }

    @Override
    public int worldSimulationReset() {
        virtualWorld.worldSimulateStop();
        return SUCCESS;
    }

    private void resetDB(){
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
        int[] location = {locationX / 100, locationY / 100};

        if (facilityType == powerStationTypeName){
            PowerStationDao mapper = sqlSession.getMapper(PowerStationDao.class);
            if(mapper.findPowerStation(facilityName) == null){
                generatePowerStation(facilityName,facilityLevel,location[ROW],location[COL]);
                facilityData = new FacilityData(powerStation, mapper.findPowerStationType(facilityLevel));
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
        else if (facilityType == electricityUnitTypeName[0] || facilityType == electricityUnitTypeName[1] ||
                 facilityType == electricityUnitTypeName[2] || facilityType == electricityUnitTypeName[3]){
            ElectricityUnitDao mapper = sqlSession.getMapper(ElectricityUnitDao.class);
            if(mapper.findElectricityUnit(facilityName) == null){
                generateElectricityUnit(facilityName,facilityLevel,location[ROW],location[COL]);
                facilityData = new FacilityData(electricityUnit, mapper.findElectricityUnitType(facilityLevel));
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

    private void generatePowerStation(String powerStationName, String powerStationType, int x, int y){
        powerStation = new PowerStation();
        powerStation.Put_powerStationId(generateId(powerStationType,x,y));
        powerStation.Put_zipCode(generateZipCode(x,y));
        powerStation.Put_powerStationType(powerStationType);
        powerStation.Put_powerStationName(powerStationName);
    }

    private void generateElectricityUnit(String electricityUnitName, String electricityUnitType, int x, int y){
        electricityUnit = new ElectricityUnit();
        electricityUnit.Put_electricityUnitId(generateId(electricityUnitType,x,y));
        electricityUnit.Put_zipCode(generateZipCode(x,y));
        electricityUnit.Put_electricityUnitType(electricityUnitType);
        electricityUnit.Put_electricityUnitName(electricityUnitName);
    }

    public int[] prim(){
        return virtualWorld.prim();
    }

    public int getLose(){
        return virtualWorld.getTotalLose();
    }
}
