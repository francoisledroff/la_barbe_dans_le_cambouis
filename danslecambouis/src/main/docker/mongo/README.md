

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