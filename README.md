README
====

* Construisez le container nginx : `./src/main/docker/build-docker-image.sh`
* Démarrer l'instance nginx: `$ docker-compose -f src/main/docker/nginx.yml up`
* Vérifier que le serveur fonctionne: `$ curl http://localhost:80/`
* Modifier la configuration fournie pour rediriger les requêtes vers votre service :9091/ping
** (Placer votre configuration dans le fichier src/main/docker/nginx-config/basic-rp/ qui sera automatiquement monté dans le répertoire /etc/nginx/conf.d/ et chargé par nginx)
