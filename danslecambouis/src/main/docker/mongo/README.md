

## Prerequisite

construisez notre container mongo en exécutant: 

`docker build -t mongo src/main/docker/mongo/`

## Test Drive

Run the mongo container :

    cd /src/main/docker/mongo/
    ./run.sh

Access the mongodb    

    ./access-ssl.sh

      > show dbs
      admin  0.000GB
      local  0.000GB
      

## pointers

* http://mongodb.github.io/mongo-java-driver/3.0/driver/reference/connecting/ssl/?_ga=1.122423051.1001600813.1475930911
* http://pauldone.blogspot.ro/2014/09/java-to-mongodb-ssl.html
* https://docs.mongodb.com/manual/tutorial/configure-x509-client-authentication/

