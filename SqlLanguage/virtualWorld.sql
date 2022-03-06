CREATE DATABASE virtualWorld;

use virtualWorld;

CREATE TABLE Zip_Code(
  ZipCode VARCHAR(10) PRIMARY KEY,
  Block_Name VARCHAR(255)
);

CREATE TABLE PowerStationType(
  Type_ID VARCHAR(10) PRIMARY KEY,
  Max_Production int
);

CREATE TABLE ElectricityUnitType(
  Type_ID VARCHAR(10) PRIMARY KEY,
  Max_Consumption int,
  Min_Consumption int
);

CREATE TABLE PowerStation(
  powerStationId VARCHAR(255) PRIMARY KEY,
  ZipCode VARCHAR(10),
  powerStationType VARCHAR(10),
  powerStationName VARCHAR(255),

  CONSTRAINT fk_zip FOREIGN KEY(ZipCode) REFERENCES Zip_Code(ZipCode),
  CONSTRAINT fk_StationType FOREIGN KEY(powerStationType) REFERENCES PowerStationType(Type_ID)
);

CREATE TABLE ElectricityUnit(
  ElectricityUnitID VARCHAR(255) PRIMARY KEY,
  ZipCode VARCHAR(10),
  ElectricityType VARCHAR(10),
  electricityUnitName VARCHAR(255),
  CONSTRAINT fk_zipElec FOREIGN KEY(ZipCode) REFERENCES Zip_Code(ZipCode),
  CONSTRAINT fk_ElecType FOREIGN KEY(ElectricityType) REFERENCES ElectricityUnitType(Type_ID)
);

CREATE TABLE ElectricityUnit_DataStore(
  DATA_REFERENCE_ID VARCHAR(255) PRIMARY KEY,
  ElectricityUnitID VARCHAR(255),
  TimeOfStore VARCHAR(18),
  ConsumptionAmount int,
  CONSTRAINT fk_ElecStore FOREIGN KEY(ElectricityUnitID) REFERENCES ElectricityUnit(ElectricityUnitID)
);

CREATE TABLE PwoerStation_DataStore(
  DATA_REFERENCE_ID VARCHAR(255) PRIMARY KEY,
  powerStationId VARCHAR(255),
  TimeOfStore VARCHAR(18),
  ProductivityAmount int,
  CONSTRAINT fk_powerStationStore FOREIGN KEY(powerStationId) REFERENCES PowerStation(powerStationId)
);
