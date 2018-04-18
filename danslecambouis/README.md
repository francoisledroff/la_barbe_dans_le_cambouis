

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
  * lisez cette doc 
  
  
* https://developer.github.com/apps/building-oauth-apps/authorization-options-for-oauth-apps/#web-application-flow
* https://developer.okta.com/blog/2017/06/21/what-the-heck-is-oauth
* https://spring.io/guides/tutorials/spring-boot-oauth2/


* Renseignez vos github `clientId` et `clientSecret` dans le fichiers de configuration Spring
* Testez l'application avec votre navigateur: `http://localhost:9091`

## Allez plus loin

faire de l'oAuth avec Keycloak
* https://developers.redhat.com/blog/2017/01/05/spring-boot-and-oauth2-with-keycloak/


### swagger (opened)

Explore our API documentation at
* browse to http://localhost:9091/swagger-ui.html

### account (auth demo)

* browse to http://localhost:9091/account/me
* be re-directed to keycloak
* user `user/password` to log in
* be redirected
* get a `TODO account for principal <keycloak-username>` for now

### stuff (csrf demo)

Try getting, posting or deleting stuff
 
    curl -v http://localhost:9091/stuff
    curl -v -H "Content-Type: application/json" -X POST -d '{"title":"un titre","text":"du texte"}' http://localhost:9091/stuff
    curl -v -H "Content-Type: application/json" -X DELETE -d '{"title":"un titre","text":"du texte"}' http://localhost:9091/stuff

You'll might get response such as

    {"timestamp":1523630530507,"status":403,"error":"Forbidden","message":"Could not verify the provided CSRF token because your session was not found.","path":"/stuff"} 

Note the various headers mitigating click-jacking, content sniffing, xss attacks and more
 
Spring Security allows users to easily inject the default security headers to assist in protecting their application.
The default for Spring Security is to include the following headers:
 
       Cache-Control: no-cache, no-store, max-age=0, must-revalidate
       Pragma: no-cache
       Expires: 0
 
       X-Content-Type-Options: nosniff
 
       Strict-Transport-Security: max-age=31536000 ; includeSubDomains
       X-Frame-Options: DENY
       X-XSS-Protection: 1; mode=block


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


### useful docker commands

docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)

* Astuce: retrouver l'IP attribué par Docker:

$ docker ps -q \
    | xargs docker inspect --format '{{ .Id }} \
    - {{ .Name }} - {{ .NetworkSettings.IPAddress }}'
