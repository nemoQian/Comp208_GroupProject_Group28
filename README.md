# **Comp_208 Group_28 Energy Management System**

域名初步定为 **group28.com**

## 代码分层：

所有后端代码均储存在：\src\main\java\com.group28 包下 暂时是这些，如果有需要，还会进行更改

该包下拥有多个额外包：

dao：对数据库与其他非原始数据的**操作层**

service: **业务逻辑层** 即对问题的各种操作，对数据层进行操作，不直接操作数据库

web: 对访问控制进行转发，各类参数校验

util：工具类，即各种工具方法

pojo: 实体类，命名需与数据库命名一 一对应



test文件夹下，有与main文件夹下同样的结构，测试类需写在对应的包下



环境version： (版本号都是建议，不是强制)

jdk 1.8

MySQL 8.0.26

Maven 3.8.4

tomcat 10.0.16

MyBatis 3.5.7

JUnit 4.12

Spring 5.3.15

SpringMVC 5.3.15



## 基本配置

MyBatis Maven 仓库  **pom.xml**

```xml
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.7</version>
</dependency>

```

MySQL Driver

```xml
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.26</version>
</dependency>
```

JUnit

```xml
<!-- https://mvnrepository.com/artifact/junit/junit -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
```

Spring WebMVC

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.15</version>
</dependency>
```

Spring JDBC

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.3.15</version>
</dependency>
```

Servlet

```xml
<!-- https://mvnrepository.com/artifact/javax.servlet/servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>servlet-api</artifactId>
    <version>2.5</version>
</dependency>
```

Maven bulid 配置

```xml
    <build>
        <resources>
            <resource>
                <directory> src/main/resources </directory>
                <includes>
                    <include> **/*.properties </include>
                    <include> **/*.xml </include>
                </includes>
            </resource>
            <resource>
                <directory> src/main/java </directory>
                <includes>
                    <include> **/*.properties </include>
                    <include> **/*.xml </include>
                </includes>
                <filtering> false </filtering>
            </resource>
        </resources>
    </build>
```



MyBatis configuration核心配置文件  mybatis-config.xml  放置在 **src/main/resources** 里面

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>

    <properties resource="db.properties" />

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC" />
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc_driver}" />
                <property name="url" value="${db_url}"/>
                <property name="username" value="${db_name}" />
                <property name="password" value="${db_pwd}" />
            </dataSource>
        </environment>
    </environments>
	
    <!-- example -->
    <mappers>
        <mapper resource="UserMapper.xml"></mapper>
    </mappers>
</configuration>
```

db.Properties 文件 放置在 **src/main/resources** 里面

```properties
jdbc_driver = com.mysql.cj.jdbc.Driver
db_url = jdbc:mysql://localhost:3306/(dbname)?useSSL=false&serverTimezone=GMT
db_name = root
db_pwd = 自己数据库的密码
```

MyBatis Mapper 映射文件 放置在 **src/main/resources** 里面

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- example -->
<mapper namespace="com.group28.dao.UserDao">
    <select id = "getUserList" resultType="com.group28.pojo.User">
        select * from mybatis.user;
    </select>
</mapper>

```



## API文档 [MyBatis]([mybatis – MyBatis 3 | Java API](https://mybatis.org/mybatis-3/zh/java-api.html))























































