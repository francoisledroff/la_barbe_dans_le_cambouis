README
====

* démarrez notre container keycloak: `docker-compose -f src/main/docker/keycloak.yml up`
* configurer le 'realm' barbus selon les spécifications fournises
* modifier le fichier `src/main/resources/application.properties` pour intégrer l'application avec Keycloak
* vérifier que l'accès au service /account requiert une authentification et que /ping reste accessible
