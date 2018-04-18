ReadMe
====

Construisez le micro service 'ping' utilisé pour nos labs:

    $ cd danslecambouis/
    $ mvnw compile (erreur de compilation)

Implémenter le corps de la méthode 'ping' puis exécuter et tester le service

    $ mvn spring-boot:run
    $ curl http://localhost:9091/ping
    pong
