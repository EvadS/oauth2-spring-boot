#Smaple 
--Здесь перечень технологий 
Cloud Config
Security
Cloud Discovery(Eureka)
Cloud Routing (Zuul)
DockerCompose 
MongoDb (Докер на порту 27001)
MongoExpress (Докер имедж 18001)
 

-- здесь перечень проектов 
:: // TODO: перечень проектов на git hub 
* Config Service
* Registry Service
* Gateway Service
* auth-service
* Account service

## последовательность запуска

1. config-server
2. registry-service
3. gateway-service
4. auth-service
5. account-service

## Readme 
1. в каждом сервисе лежит вспомагательное реадми 
2. предполагается что все работает в скопе, но дальнейшего тестирования ConfigService - я разделил на субпроекты в гите 

3. Отдельно внимание для монго 
сейчас база на сохраняется - нужно проверить скрипт добавления пользователя после запуска монги 
если пробросить монгу наверх (сохранять между перезапусками контейнера - то может быть проблема с первый добавлением пользователя).
##Demo 
шаг 1 
POST
http://localhost:8080/uaa/oauth/token 
Authorization 
	Basic Auth 
		username : browser
		pass:    1234
Body: 
x-www-form-urlencoded
grant_type  password 
username    randomuser
password  1234

шаг 2 

создать пользователя 
http://localhost:8080/accounts/
{
	"username":"my_evad_se",
	"password":"123456"
}

шаг 3 
текущиие польщователи 
GET
http://localhost:8080/uaa/user/current

Barrer Token 73c6edda-e5a4-4b06-af32-9736f1cddf86 

параметром будет access_token из первого запроса 




-- здесь post man 


## краткое описание 
###Config Service

Храним конфишурацию для сервисов 
В основе Config server (cloud config)
 
resources -> shared конфиги (имя_сервиса.yml )
каждый сервис должен содержать bootstrap.yml
bootstrap.yml загружается раньше application.yml.

при использовании Spring Cloud Config сервера, следует указать spring.application.name и spring.cloud.config.server.git.uri внутри bootstrap.yml
некоторые encryption/decryptionсведения
Технически, bootstrap.yml загружается родительской Spring ApplicationContext. Этот родитель ApplicationContextбудет загружен до того, что используется application.yml.

ДЛЯ КАЖДОГО ДОБЯВЛЯЕМОГО СЕРВИСА ДОЛЖНА БЫТЬ КОНФИГУРАЦИЯ 

Здесь заюзали spring-boot-starter-security
 password: 1234

с пользователем как - то интересно 
auth-server
com.se.sample.authservice.config.mongodb.changelogs
InitialValuesChangeLog - > insertUserToTestAuthentication

user: <b>randomuser</b>

значение для для юзернейм (для Basic Auth) берем в этом же месте в  insertBrowserClientDetails()



### registry service
 using the Netflix Eureka. 
Размещается на пути http://localhost:8761/


### Gateway Service

Spring Netflix Zuul.
forward requests to other services.
Здесь настраиваем рауты 

например 
  routes:
    auth-service: #имя сервиса 
      path: /uaa/** #path если путь содержит это
      url: auth-service # то перейдем сюда 

http://localhost:8080/uaa/oauth/token 
есть /uaa/** значит мы должны попасть в auth-service (имя хранит Eureka) и щем уже там апишку 
/oauth/token (в данном случае она под капотом, посколько мы подключили Oauth стартер)

ВАЖНО: этот сервис является отправной точкой!!! 


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

для докера также собрано несколько пример в сервисе auth-service
## auth-service
сервер авторизации 

требует детального рассмотрения 
В общих чертах здесь авторизация и хранение я в базе пользователей 

##account service 
регистрация пользователей 
В общих чертах здесь должна быть вся логика 




