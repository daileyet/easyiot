# Easyiot Server Project

## iot-common

Server common project include 
* mybatis generator plugin
* mysql connector
* app common configuration
* utilties
* sample db schema
* sharding-sphere jdbc

## iot-links

Server backend project which will handle client TCP/UDP connection, it will include
* spring-boot start
* netty support
* support TCP channel and JSON message received base on netty
* include `iot-common`

## iot-web

Server web protal which serve HTTP request
* spring-boot start
* tomcat or undertow
* use thymeleaf, spring-security
* include `iot-common`