# Spring-Boot ==> MyBatis


## **E**nvironment

* MyBatis
* Lombok
* Liquibase
* Swagger

## Install

```bash
[build.gradle]
dependencies {
  ...
	implementation 'mysql:mysql-connector-java:5.1.46'
	implementation 'org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4:1.16'
	implementation "org.mybatis.spring.boot:mybatis-spring-boot-starter:1.3.1"
  ...
	implementation 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'
  ... 
	implementation "org.liquibase:liquibase-core:3.10.1", {
		exclude group: "ch.qos.logback", module: "logback-classic"
	}
  ... 
  implementation 'io.springfox:springfox-swagger2:2.6.1'
	implementation 'io.springfox:springfox-swagger-ui:2.6.1'
  ...
}
```


