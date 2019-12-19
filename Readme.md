#Smaple 
* Config Service
* Registry Service
* Gateway Service


###Config Service

Храним конфишурацию для сервисов 
В основе Config server (cloud config)
 
resources -> shared конфиги (имя_сервиса.yml )

### registry service
 using the Netflix Eureka. 
Размещается на пути http://localhost:8761/

### Gateway Service

Spring Netflix Zuul.
forward requests to other services.

возможно пондобиться 
это первый шаг. При первом обращении к gateway мы увидим встроенное окно авторизации 
      password: 1234 #password of the config-service
      username: user #username of the config-service

##Mongo DB 

статус 
sudo service mongod status

стопнуть
sudo service mongod stop

## Docker

You need to have Docker installed

 run the command 
 ``` docker-compose up --build ``` in your preferred terminal to create and start the MongoDB container


