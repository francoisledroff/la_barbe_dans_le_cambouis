

## Test Drive

* start keycloak docker `docker-compose -f src/main/docker/keycloak.yml up`
* start this from your IDE using `DanslecambouisApplication`


### ping (opened)

* ping our barbus-app, by browsing to http://localhost:9091/ping
* get a `pong`

### account (secured)

* browse to http://localhost:9091/account
* be re-directed to keycloak
* user `user/password` to log in
* be redirected
* get a `TODO account for principal <keycloak-username>` for now

### swagger

Explore our API documentation at
* browse to http://localhost:9091/swagger-ui.html
  * the json spec is available at http://localhost:9091/v2/api-docs


## Misc Pointers, notes and references

### Keycloak:

* https://www.keycloak.org/archive/downloads-3.4.3.html
* https://developers.redhat.com/blog/2017/05/25/easily-secure-your-spring-boot-applications-with-keycloak/
* https://www.keycloak.org/docs/3.3/server_admin/topics/export-import.html

to export the keycloak realm and users

    bin/standalone.sh -Dkeycloak.migration.action=export -Dkeycloak.migration.provider=dir -Dkeycloak.migration.dir=/Users/ledroff/workspace/github/la_barbe_dans_le_cambouis/danslecambouis/src/main/docker/realm-config-export

### KeyCloak and spring security

* https://developers.redhat.com/blog/2017/05/25/easily-secure-your-spring-boot-applications-with-keycloak/

### swagger:

* http://springfox.github.io/springfox/docs/current
* https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/
* http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
  * https://github.com/eugenp/tutorials/blob/master/spring-security-rest
