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
