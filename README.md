# Embedded MySQL Spring Boot Starter

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