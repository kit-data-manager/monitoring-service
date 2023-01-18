![Docker Cloud Build Status](https://img.shields.io/docker/cloud/build/kitdm/monitoring-service)

# Docker Configuration - monitoring-service

This repository contains a the docker configuration files for the monitoring-service service of KIT DM 2.0 repository platform. It is build and hosted at [DockerHub](https://hub.docker.com/) and can be found under the namespace ***kitdm***. 

## Prerequisites

* docker (tested with 18.09.2)

## Building and Startup

Typically, there is no need for locally building images as all version are accessible via [DockerHub](https://hub.docker.com/).

Running for example a monitoring-service instance can be achieved as follows:

```
user@localhost:/home/user/$ docker run -p 8080:8080 kitdm/monitoring-service
[...]
user@localhost:/home/user/$
```

In some cases, you may want to change the configuration of the service instance. All service-specific configuration is located in each image at

```/monitoring-service/config/application.properties```

You can easily overwrite this file by creating an own Dockerfile, which looks as follows in case of the monitoring-service service:

```
FROM kitdm/monitoring-service:latest

COPY application.properties /monitoring-service/config/application.properties
```

Afterwards, you have to build the modified image locally by calling:

```
user@localhost:/home/user/my-monitoring-service/$ docker build .
[...]
user@localhost:/home/user/my-monitoring-service/$
```

Now, you can start the container using your modified configuration.

## License

The KIT Data Manager is licensed under the Apache License, Version 2.0.
