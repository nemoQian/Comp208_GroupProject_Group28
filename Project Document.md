# Project Document 

## Introduction

This document shows the information of interface and object in each package. Up to now, there are 10 object and 3 interface.

## Object:

Under the package **com.group28.pojo**

Each object only have **get** function

### **User**

```java
// @param
private String user_Name;
private String user_Password;
private String user_Email;
```

```java
// constructor
public User(String user_Name, String user_Password, String user_Email) {
        this.user_Name = user_Name;
        this.user_Password = user_Password;
        this.user_Email = user_Email;
}
```



### **ZipCode**

```java
// @param
private String ZipCode;
private String block_Name;
```

```java
// constructor
public ZipCode(String ZipCode, String block_Name) {
        this.ZipCode = ZipCode;
        this.block_Name = block_Name;
}
```



### **Facility**

```java
// @param
private ZipCode zipCode;
private FacilityType facilityType;
private int facilityId;
private String facilityName;
```

```java
// constructor
public Facility(ZipCode zipCode, FacilityType facilityType,
                    int facilityId, String facilityName) {
        this.zipCode = zipCode;
        this.facilityType = facilityType;
        this.facilityId = facilityId;
        this.facilityName = facilityName;
}
```



### **FacilityType**

```java
// @param
private String type_Id;
private Long MAX_NUMERICAL;
private Long MIN_NUMERICAL;
```

```java
// constructor
public FacilityType(String type_Id, Long MAX_NUMERICAL) {
        this.type_Id = type_Id;
        this.MAX_NUMERICAL = MAX_NUMERICAL;
}

public FacilityType(String type_Id, Long MAX_NUMERICAL, Long MIN_NUMERICAL) {
        this.type_Id = type_Id;
        this.MAX_NUMERICAL = MAX_NUMERICAL;
        this.MIN_NUMERICAL = MIN_NUMERICAL;
}
```



### **PowerStation** -- subclass of **Facility**

```java
// @param
private ZipCode zipCode;
private PowerStationType powerStationType;
private int powerStationId;
private String powerStationName;
```

```java
// constructor
public PowerStation(ZipCode zipCode, PowerStationType powerStationType,
                        int powerStationId, String powerStationName) {
        super(zipCode, powerStationType, powerStationId, powerStationName);
}
```



### **ElectricityUnit** -- subclass of Facility

```java
// @param
private ZipCode zipCode;
private ElectricityUnitType electricityUnitType;
private int electricityUnitId;
private String electricityUnitName;
```

```java
// constructor
public ElectricityUnit(ZipCode zipCode, 
                       ElectricityUnitType electricityUnitType,
                       int electricityUnitId, String electricityUnitName) {
        super(zipCode, electricityUnitType, 
              electricityUnitId, electricityUnitName);
}
```



### **PowerStationType** -- subclass of  FacilityType

```java
// @param
private String type_Id;
private Long MAX_PRODUCTION;
```

```java
// constructor
public PowerStationType(String type_Id, Long MAX_PRODUCTION) {
        super(type_Id,MAX_PRODUCTION);
}
```



### **ElectricityUnitType** -- subclass of FacilityType

```java
// @param
private String type_Id;
private Long MAX_CONSUMMPTION;
private Long MIN_CONSUMMPTION;
```

```java
// constructor
public ElectricityUnitType(String type_Id, 
                           Long MAX_CONSUMMPTION, Long MIN_CONSUMMPTION) {
        super(type_Id, MAX_CONSUMMPTION, MIN_CONSUMMPTION);
}
```



### **PowerStationData**

```java
// @param
private final String DATA_REFERENCE_ID;
private PowerStation powerStation;
private String timeOfStore;
private Long productivityAmount;
```

```java
// constructor
public PowerStationData(String DATA_REFERENCE_ID, PowerStation powerStation,
                            String timeOfStore, Long productivityAmount) {
        this.DATA_REFERENCE_ID = DATA_REFERENCE_ID;
        this.powerStation = powerStation;
        this.timeOfStore = timeOfStore;
        this.productivityAmount = productivityAmount;
    }
```



### **ElectircityUnitData**

```java
// @param
private final String DATA_REFERENCE_ID;
private ElectricityUnit electricityUnit;
private String timeOfStore;
private Long ConsumptionAmount;
```

```java
// constructor
public ElectricityUnitData(String DATA_REFERENCE_ID, 
                           ElectricityUnit electricityUnit,
                           String timeOfStore, Long consumptionAmount) {
        this.DATA_REFERENCE_ID = DATA_REFERENCE_ID;
        this.electricityUnit = electricityUnit;
        this.timeOfStore = timeOfStore;
        ConsumptionAmount = consumptionAmount;
    }
```



## **Interface**

Under the package **com.group28.dao**

### **ZipCodeDao**

```java
List<ZipCode> getZipCodeList();

ZipCode getZipCode(String ZipCode);

void addZipCode(ZipCode zipCode);
```



Under the package **com.group28.util**

### **SimulateTimeInterface**

```java
void simulateSeconds();

void simulateMinutes();

void simulateHours();

void simulateDays();

void simulateMonths();

int getHour();

int getDay();

int getMonth();

long getYear();

String getTimeNow();

String getFrontReferenceId();

void simulationOpen();

void simulationStop();
```







































