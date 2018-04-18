

## Prerequisite

* you can stop the keycloak docker


## Test Drive
Once the above is done

* start the app : `mvnw clean install spring-boot:run`
  * or run/debug `DanslecambouisApplication` from your IDE  


### ping (opened)

* ping our barbus-app, by browsing to http://localhost:9091/ping
* get a `pong`

## lab6 

* Nous allons passer de KeyCloak à Github et utiliser GitHub en tant que fournisseur d'identité.
* Nous allons nous appuyer sur la norme ouverte pour l'autorisation appelée oAuth2
  * [What the Heck is oAuth ?](https://developer.okta.com/blog/2017/06/21/what-the-heck-is-oauth)
*  Créez une application OAuth sur Github
  * lisez ces docs 
    * https://developer.github.com/apps/building-oauth-apps/authorization-options-for-oauth-apps/#web-application-flow
    * https://developer.okta.com/blog/2017/06/21/what-the-heck-is-oauth
    * https://spring.io/guides/tutorials/spring-boot-oauth2/
  

* Renseignez vos github `clientId` et `clientSecret` dans le fichiers de configuration Spring
* Testez l'application avec votre navigateur: `http://localhost:9091`

* Comment faire pour ne pas partager ces secrets sur le repo de source ?

Essayez de jouer avec notre API avec curl

    curl -v http://localhost:9091/stuff

    curl -v -H "Content-Type: application/json" --cookie "JSESSIONID=2E805872082A7B62043F3FEB3782FD58" -X POST  http://localhost:9091/stuff

pas très REST ?
et oAuth ?


## Allez plus loin

faire de l'oAuth avec Keycloak
* https://developers.redhat.com/blog/2017/01/05/spring-boot-and-oauth2-with-keycloak/



## Misc Pointers, notes and references

### Keycloak:

* https://www.keycloak.org/archive/downloads-3.4.3.html
* https://developers.redhat.com/blog/2017/05/25/easily-secure-your-spring-boot-applications-with-keycloak/
* https://www.keycloak.org/docs/3.3/server_admin/topics/export-import.html

to export the keycloak realm and users

    bin/standalone.sh -Dkeycloak.migration.action=export -Dkeycloak.migration.provider=dir -Dkeycloak.migration.dir=/Users/ledroff/workspace/github/la_barbe_dans_le_cambouis/danslecambouis/src/main/docker/realm-config-export

### swagger:

* http://springfox.github.io/springfox/docs/current
* https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/
* http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
  * https://github.com/eugenp/tutorials/blob/master/spring-security-rest

### KeyCloak and spring security

* https://developers.redhat.com/blog/2017/05/25/easily-secure-your-spring-boot-applications-with-keycloak/

##### spring security 

* https://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html
* https://docs.spring.io/spring-security/site/docs/current/reference/html/headers.html#headers-cache-control

* webinar https://spring.io/blog/2014/01/21/webinar-replay-spring-security-3-2

##### spring security 

* https://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html
* https://docs.spring.io/spring-security/site/docs/current/reference/html/headers.html#headers-cache-control

* webinar https://spring.io/blog/2014/01/21/webinar-replay-spring-security-3-2

###### oauth

* https://developer.okta.com/blog/2017/06/21/what-the-heck-is-oauth
* https://developers.redhat.com/blog/2017/01/05/spring-boot-and-oauth2-with-keycloak/
* https://spring.io/guides/tutorials/spring-boot-oauth2/
* https://github.com/spring-guides/tut-spring-boot-oauth2/blob/master/github/src/main/java/com/example/SocialApplication.java


### useful docker commands

docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)

* Astuce: retrouver l'IP attribué par Docker:

$ docker ps -q \
    | xargs docker inspect --format '{{ .Id }} \
    - {{ .Name }} - {{ .NetworkSettings.IPAddress }}'
