#Explanation

* <i>version</i> is a version of docker-compose file format, you can change to the latest version

* <i>database</i> on line 3 is just a service name, you can change the name whatever you want

* <i>image</i> must be mongo, because you want to create a container from mongo image
* <i>container_name</i> is a name for your container, it’s optional

* <i>environment</i> is a variables that will be used on the mongo container

    * MONGO_INITDB_DATABASE you fill with a database name that you want to create, make it same like init-mongo.sh

    * MONGO_INITDB_ROOT_USERNAME you fill with username of root that you want

    * MONGO_INITDB_ROOT_PASSWORD you fill with password of root that you want
* <i>volumes</i> to define a file/folder that you want to use for the container

* <i>./init-mongo.sh:/docker-entrypoint-initdb.d/init-mongo-js:ro</i> means you want to copy init-mongo.sh to /docker-entrypoint-initdb.d/ as a read only file. /docker-entrypoint-initdb.d is a folder that already created inside the mongo container used for initiating database, so we copy our script to that folder

* <i>./mongo-volume:/data/db</i> means you want to set data on container persist on your local folder named mongo-volume . /data/db/ is a folder that already created inside the mongo container.

* <i>ports</i> is to define which ports you want to expose and define, in this case I use default mongoDB port 27017 until 27019

##Execution

``` docker-compose up -d ```

Login to your container by using container names
```  docker exec -it <container-name> bash ```

Login to MongoDB with created User & Database by using

``` mongo -u <your username> -p <your password> --authenticationDatabase <your database name> ```
##### OR ######
``` mongo -u <your username> --authenticationDatabase <your database name> ```

### в нашем случае

```  mongo -u se -p 123456 my-database ```
 

You can connect your program to the database by using this URL as a connection mongodb://YourUsername:YourPasswordHere@127.0.0.1:27017/your-database-name


mongodb://se:123456@127.0.0.1:27017/my-database


 docker-compose -f  docker-compose-express.yml  up
 
 
 ``` docker-compose -f mongo-compose-network.yml up ```
 
 
docker-compose -f docker-compose-express.yml up

Админ панель
http://localhost:10081/db/admin/
