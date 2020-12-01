#!/bin/bash

cd /monitoring-service
java -cp ".:./config:./monitoring-service.jar" -Dloader.path=file://`pwd`/monitoring-service.jar,./lib/,. -jar monitoring-service.jar
