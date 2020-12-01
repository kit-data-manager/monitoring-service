FROM openjdk:11-stretch AS build-env-java
MAINTAINER webmaster@datamanager.kit.edu
LABEL stage=build-env

RUN apt-get update && \
    apt-get upgrade --assume-yes && \
    apt-get install --assume-yes git && \
    mkdir -p /monitoring-service/

FROM build-env-java AS build-monitoring-service
MAINTAINER webmaster@datamanager.kit.edu
LABEL stage=build-contains-sources

COPY build.sh /monitoring-service/

RUN sh /monitoring-service/build.sh

FROM openjdk:11-stretch AS run-monitoring-service
MAINTAINER webmaster@datamanager.kit.edu
LABEL stage=run


RUN mkdir -p /monitoring-service/config/
COPY --from=build-monitoring-service /monitoring-service/monitoring-service/build/libs/monitoring-service.jar /monitoring-service/monitoring-service.jar
COPY --from=build-monitoring-service /monitoring-service/monitoring-service/config/application-default.properties /monitoring-service/application.properties
COPY run.sh /monitoring-service/

EXPOSE 8060
ENTRYPOINT ["sh", "/monitoring-service/run.sh"]
