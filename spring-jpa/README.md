# Spring-Boot ==> JPA


## **E**nvironment

* JPA
* QueryDSL
* Lombok
* Swagger

## Install

```bash
[build.gradle]
plugins {
  id 'com.ewerk.gradle.plugins.querydsl' version '1.0.10'
  ...
}
...
apply plugin: "com.ewerk.gradle.plugins.querydsl"
...
dependencies {
  ...
  implementation 'mysql:mysql-connector-java:5.1.46'
  implementation 'org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4:1.16'
  implementation "org.mybatis.spring.boot:mybatis-spring-boot-starter:1.3.1"
  ... 
  compile("com.querydsl:querydsl-jpa")
  compile("com.querydsl:querydsl-apt")
  ...
  implementation 'org.projectlombok:lombok'
  annotationProcessor 'org.projectlombok:lombok'
  ... 
  implementation 'io.springfox:springfox-swagger2:2.6.1'
  implementation 'io.springfox:springfox-swagger-ui:2.6.1'
  ...
}

// querydsl 적용
def querydslSrcDir = 'src/main/generated'

querydsl {
  library = "com.querydsl:querydsl-apt"
  jpa = true
  querydslSourcesDir = querydslSrcDir
}

compileQuerydsl{
  options.annotationProcessorPath = configurations.querydsl
}

configurations {
  querydsl.extendsFrom compileClasspath
}

sourceSets {
  main {
    java {
      srcDirs = ['src/main/java', querydslSrcDir]
    }
  }
}
```
