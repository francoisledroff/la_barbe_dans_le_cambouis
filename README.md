README
====

* regardez la configuration fournie `src/main/docker/nginx-config/conf.d/nginx.ssl.conf`
* générer les certificats nécessaires et ajoutez le volume associé dans `src/main/docker/nginx.yml`
* tester que SSL fonctionne (https://localhost:443/)
* tester que /ping and /account sont toujours accessible via https

* Documentation pour la génération des certificats et clés nécessaires: https://www.digitalocean.com/community/tutorials/how-to-create-a-self-signed-ssl-certificate-for-nginx-on-centos-7
