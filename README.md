# Embedded MySQL Spring Boot Starter

### What It Is

It is an embedded MySQL for instead H2/Sqlite etc.

Before use,Please OPEN <https://github.com/liuyuyu/embedded-mysql-spring-boot/blob/master/embedded-mysql-demo/README.md>

## Usage
add dependency in pom.xml
```xml
<dependency>
  <groupId>io.github.liuyuyu</groupId>
  <artifactId>embedded-mysql-spring-boot-starter</artifactId>
  <version>0.0.1</version>
</dependency>
```
application.properties
```properties
# Enable MySQL
spring.datasource.embedded.mysql.enable=true

spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3333/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2b8&nullNamePatternMatchesAll=true
# username. Always correct!
spring.datasource.username=test_user
# password. Always correct!
spring.datasource.password=

# MySQL port
spring.datasource.embedded.mysql.port=3333
# DML v1_1_function.sql,v1_2_init_data.sql
spring.datasource.embedded.mysql.script-locations=classpath:/sql/*.sql
# MySQL Version
spring.datasource.embedded.mysql.version=v5_6_21
```
Run XXXSpringApplication.java
Console will output log like this first time
```
2019-04-19 19:54:11.110  INFO 14499 --- [           main] com.wix.mysql.EmbeddedMysql              : Preparing EmbeddedMysql version 'Version 5.6.21'...
Download Version 5.6.21:OS_X:B64 START
Download Version 5.6.21:OS_X:B64 DownloadSize: 173770339
Download Version 5.6.21:OS_X:B64 0%
Download Version 5.6.21:OS_X:B64 5%
...........
Download Version 5.6.21:OS_X:B64 100%
Download Version 5.6.21:OS_X:B64 downloaded with 747kb/s
Download Version 5.6.21:OS_X:B64 DONE
Extract /Users/liuyuyu/.embedmysql/MySQL-5.6/mysql-5.6.21-osx10.9-x86_64.tar.gz START
...........
Extract /Users/liuyuyu/.embedmysql/MySQL-5.6/mysql-5.6.21-osx10.9-x86_64.tar.gz DONE
2019-04-19 19:58:05.062  INFO 14499 --- [           main] com.wix.mysql.MysqldExecutable           : Preparing mysqld for startup
2019-04-19 19:58:08.772  INFO 14499 --- [           main] com.wix.mysql.MysqldExecutable           : Starting MysqldProcess
2019-04-19 19:58:09.369  INFO 14499 --- [           main] d.f.embed.process.runtime.Executable     : start com.wix.mysql.config.MysqldConfig@122635ef
```
enjoy it Luck Dog!





### MySQL Version

`spring.datasource.embedded.mysql.version`

```
v5_5_40
v5_5_50
v5_5_51
v5_5_52
v5_5_latest
v5_6_21
v5_6_22
v5_6_23
v5_6_24
v5_6_31
v5_6_32
v5_6_33
v5_6_34
v5_6_35
v5_6_36
v5_6_latest
v5_7_10
v5_7_13
v5_7_14
v5_7_15
v5_7_16
v5_7_17
v5_7_18
v5_7_19
v5_7_latest
```

### MySQL Installer Folder
If the download address is `https://cdn.mysql.com//archives/mysql-5.6/mysql-5.6.21-winx64.zip`, the installation directory is `~/.embedmysql/MySQL-5.6/mysql-5.6.21-winx64.zip`, you can download the zip file yourself and extract it to the corresponding directory.