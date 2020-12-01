FROM openjdk:11-stretch AS build-env-java
MAINTAINER webmaster@datamanager.kit.edu
LABEL stage=build-env

RUN apt-get update && \
    apt-get upgrade --assume-yes && \
    apt-get install --assume-yes git && \
    mkdir -p /admin-service/

FROM build-env-java AS build-admin-service
MAINTAINER webmaster@datamanager.kit.edu
LABEL stage=build-contains-sources

COPY build.sh /admin-service/

RUN sh /admin-service/build.sh

FROM openjdk:11-stretch AS run-admin-service
MAINTAINER webmaster@datamanager.kit.edu
LABEL stage=run


RUN mkdir -p /admin-service/config/
COPY --from=build-admin-service /admin-service/admin-service/build/libs/admin-service.jar /admin-service/admin-service.jar
COPY --from=build-admin-service /admin-service/admin-service/config/application-default.properties /admin-service/application.properties
COPY run.sh /admin-service/

EXPOSE 8060
ENTRYPOINT ["sh", "/admin-service/run.sh"]
