# KIT Data Manager - Monitoring-Service

![Build Status](https://img.shields.io/travis/kit-data-manager/monitoring-service.svg)
![License](https://img.shields.io/github/license/kit-data-manager/monitoring-service.svg)
![Docker Cloud Build Status](https://img.shields.io/docker/cloud/build/kitdm/monitoring-service)
![Docker Image Version (latest semver)](https://img.shields.io/docker/v/kitdm/monitoring-service)

This project provides a service monitoring Spring Boot Microservices. It is based on [Spring Boot Admin](https://github.com/codecentric/spring-boot-admin).

## How to build

In order to build the Monitoring Service you'll need:

* Java SE Development Kit 8 or higher

After obtaining the sources change to the folder where the sources are located perform the following steps:

```
user@localhost:/home/user/monitoring-service$ ./gradlew build
> Configure project :
<-------------> 0% EXECUTING [0s]
[...]
user@localhost:/home/user/monitoring-service$
```

The Gradle wrapper will now take care of downloading the configured version of Gradle, checking out all required libraries, build these
libraries and finally build the monitoring-service itself. As a result, a fat jar containing the entire service is created at 'build/jars/monitoring-service.jar'.

## How to start

### Setup
Before you are able to start the microservice, you may modify the default 'application.properties' according to your local setup. 
Therefor, copy and rename the file 'config/application-default.properties' to 'application.properties' in your project folder and customize it. You may change the server.port property. All other properties can be ignored for the time being.

As soon as you finished modifying 'application.properties', you may start the Monitoring Service by executing the following command inside the project folder, 
e.g. where the service has been built before:

```
user@localhost:/home/user/monitoring-service$ ./build/libs/monitoring-service.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.0.5.RELEASE)
[...]
1970-01-01 00:00:00.000  INFO 56918 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8060 (http) with context path ''

```

As soon as the microservice is started, you can browse to 

http://localhost:8060/

in order to see the UI. You may have to adapt the port according to your local settings.

## Setup Services to Report to Monitoring Service

In order to obtain information you'll now need to setup one or more services to send information to the Monitoring Service.
Therefor, you have to perform a few steps at the reporting service:

1. Add dependency `implementation("de.codecentric:spring-boot-admin-starter-client:2.1.6")` to build.gradle
2. Add Monitoring Service URL to 'application.properties', e.g. `spring.boot.admin.client.url=http://localhost:8060`
3. Set name of the service as it should appear in the Monitoring Service, e.g. `spring.boot.admin.client.instance.name=My Service`
4. Expose Spring Boot management endpoints in 'application.properties' via `management.endpoints.web.exposure.include: *`

On the next startup, the service should appear in the Monitoring Service UI.

## License

The KIT Data Manager is licensed under the Apache License, Version 2.0.
