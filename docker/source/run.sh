#!/bin/bash

cd /admin-service
java -cp ".:./config:./admin-service.jar" -Dloader.path=file://`pwd`/admin-service.jar,./lib/,. -jar admin-service.jar
