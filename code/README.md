# Easyiot Server Project

## iot-common

Server common project include 
* mybatis generator plugin
* mysql connector
* app common configuration
* utilties
* sample db schema
* sharding-sphere jdbc

### Build

```shell
# -m module name
# -a action 1: build&install 2:spring-boot run 3:setup eclipse project structure
# -o option 1: enable generate mybatis model and mapper 2: use war as package style
python mk.py -m iot-common -a 1 -o 1
# OK for use short module name
python mk.py -m common -a 1 -o 1
```

## iot-links

Server backend project which will handle client TCP/UDP connection, it will include
* spring-boot start
* netty support
* support TCP channel and JSON message received base on netty
* include `iot-common`

### Build

```shell
python mk.py -m iot-links -a 1
# OK for use short module name
python mk.py -m links -a 1
```

## iot-web

Server web protal which serve HTTP request
* spring-boot start
* tomcat or undertow
* use thymeleaf, spring-security
* include `iot-common`

### Build

```shell
python mk.py -m iot-web -a 1
# OK for use short module name
python mk.py -m web -a 1 -o 2
```

