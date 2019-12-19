# Mongo 

## Local instance 

###проеверяем 
``` service mongod status ```
 
####запуск 
``` sudo service mongod start ```

по аналогии стопаем и рестартим 

##Docker 

При условии что у вас установлен docker, приступим.

``` docker pull mongo ```

Проверить можем так

``` docker images ```

Запуск Mongo
(по умолчанию используется порт 27017, поэтому можем не указывать его)

``` docker run mongo ```

или можете явно указать порт

``` docker run mongo --port 27017 ```

Открываем новую консоль, пишем

``` mongo ```

В консоли в mongo

``` use dbtest ```

автоматически создаст вам базу dbtest и будет использовать ее.

``` show collections ```


------------------------------------------
```  docker run -d -p 27017-27019:27017-27019 --name mongodb mongo:4.0.4 ```

## внгутренний порт 27017 наружный 27018

```  docker run -d -p 27017:27018 --name mongodb-27018 mongo:4.0.4 ```

консолька 

``` $ docker exec -it <container-name> bash ```
# docker + docker-compose


pull latest MongoDB image by executing command below

``` docker pull mongo:latest ```
---------------------------------------
init-mongo.sh


