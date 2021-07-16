# Spring-Boot ==> Kafka


## **E**nvironment

* Kafka
* Lombok
* Swagger

## Build

```bash
[build.gradle]
...
dependencies {
  ...
  implementation 'org.springframework.kafka:spring-kafka'
  ...
  implementation 'org.projectlombok:lombok'
  annotationProcessor 'org.projectlombok:lombok'
  ... 
  implementation 'io.springfox:springfox-swagger2:2.6.1'
  implementation 'io.springfox:springfox-swagger-ui:2.6.1'
  ...
}
```
