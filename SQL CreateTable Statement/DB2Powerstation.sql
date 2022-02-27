CREATE TABLE Zip_Code(
    ZipCode VARCHAR(10) PRIMARY KEY,
    Block_Name VARCHAR(255)
);

CREATE TABLE PowerStation_Type(
    Type_ID VARCHAR(10) PRIMARY KEY,
    Max_Production int(20)
);

CREATE TABLE ElectricityUnit_Type(
    Electricity_ID VARCHAR(10) PRIMARY KEY,
    Max_Consumption int(20),
    Mini_Consumption int(20)
);

CREATE TABLE PowerStation(
    ZipCode VARCHAR(10),
    Station_Type VARCHAR(10),
    Station_ID VARCHAR(255) PRIMARY KEY,
    Name VARCHAR(255),
    CONSTRAINT fk_zip FOREIGN KEY(ZipCode) REFERENCES Zip_Code(ZipCode),
    CONSTRAINT fk_StationType FOREIGN KEY(Station_Type) REFERENCES PowerStation_Type(Type_ID)
);

CREATE TABLE Electricity_Unit(
    ZipCode VARCHAR(10),
    Electricity_Type VARCHAR(10),
    Electricity_Unit_ID VARCHAR(255) PRIMARY KEY,
    Name VARCHAR(255),
    CONSTRAINT fk_zipElec FOREIGN KEY(ZipCode) REFERENCES Zip_Code(ZipCode),
    CONSTRAINT fk_ElecType FOREIGN KEY(Electricity_Type) REFERENCES ElectricityUnit_Type(Electricity_ID)
);

CREATE TABLE ElectricityUnit_Data_Store(
    Reference_ID VARCHAR(255) PRIMARY KEY,
    Electricity_Unit_ID VARCHAR(255),
    TimeOfStore date,
    ConsumptionAmount int(20),
    CONSTRAINT fk_ElecStore FOREIGN KEY(Electricity_Unit_ID) REFERENCES Electricity_Unit(Electricity_Unit_ID)
);

CREATE TABLE PwoerStation_Data_Store(
    StationReference_ID VARCHAR(255) PRIMARY KEY,
    Station_ID VARCHAR(255),
    TimeOfStore date,
    ProductivityAmount int(20),
    CONSTRAINT fk_StationStore FOREIGN KEY(Station_ID) REFERENCES PowerStation(Station_ID)
);
