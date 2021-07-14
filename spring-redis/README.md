# Spring-Boot ==> Redis


## **E**nvironment

* Redis
* Lettuce
* Lombok
* Swagger

## Build

```bash
[build.gradle]
...
dependencies {
  ...
  compile group: 'org.springframework.boot', name: 'spring-boot-starter-data-redis', version: '1.4.0.RELEASE'
  compile group: 'io.lettuce', name: 'lettuce-core', version: '5.1.2.RELEASE'
  ...
  implementation 'org.projectlombok:lombok'
  annotationProcessor 'org.projectlombok:lombok'
  ... 
  implementation 'io.springfox:springfox-swagger2:2.6.1'
  implementation 'io.springfox:springfox-swagger-ui:2.6.1'
  ...
}
```
