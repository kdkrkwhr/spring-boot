# Spring-Boot ==> Elastic-stack


## **E**nvironment

* JPA
* Elasticsearch
* Logstash
* Lombok
* Swagger

## Build

```bash
[build.gradle]
...
dependencies {
  ...
  implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
  ...
  implementation group: 'net.logstash.logback', name: 'logstash-logback-encoder', version: '4.11'
  implementation group: 'org.springframework.data', name: 'spring-data-elasticsearch', version: '4.1.3'
  ...
  implementation 'org.projectlombok:lombok'
  annotationProcessor 'org.projectlombok:lombok'
  ... 
  implementation 'io.springfox:springfox-swagger2:2.6.1'
  implementation 'io.springfox:springfox-swagger-ui:2.6.1'
  ...
}

```
