


start keycloak docker

    docker-compose -f src/main/docker/keycloak.yml up


## notes to self

to export the keycloak realm and users

    bin/standalone.sh -Dkeycloak.migration.action=export -Dkeycloak.migration.provider=dir -Dkeycloak.migration.dir=/Users/ledroff/workspace/github/la_barbe_dans_le_cambouis/danslecambouis/src/main/docker/realm-config-export

