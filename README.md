### La Barbe dans le cambouis : Sécurisons une bonne vieille application Java "Entreprise"

c'est le titre de notre prochain **[Hands-on-lab](https://cfp.devoxx.fr/2018/talk/ZFX-8309/La_Barbe_dans_le_cambouis_:_Securisons_une_bonne_vieille_application_Java_%22Entreprise%22) à [Devoxx France 2018](https://devoxx.fr/)**

      A travers un audit de sécurité partiel, partial mais participatif, François et Romain vous proposent dans cette session de corriger un cas d’étude : une bonne vieille application Java "Entreprise".

      Y seront illustrés et débattus concepts & techniques couvrant l'ensemble du cycle de vie du développement logiciel comme

      * la gestion des secrets
      * la sécurisation de la JVM et l’analyse des flux
      * la gestion d'identité et d'autorisation avec KeyCloak, SAML & oAuth2

      Le but : vous sensibiliser, vous armer contre les cyber-attaques des hordes barbares, vous développeurs Java, barbus ou pas.

      Ce Hands-on-Lab reprendra les éléments évoqués durant la conférence donnée à Devoxx en 2015 et l'article paru dans Linux Mag en 2017 intitulés `Chez les Barbus – Java & Sécurité`.



###  Prérequis ( `Venez ! mais venez préparé !` )

* Systèmes d'exploitation:
  * Linux: bien, désactiver `SELinux`
  * MacOS: Démerdez vous, bande d'hipster
  * Windows: Merci d'installer un vrai OS
    * ou a minima faites en sorte d'avoir un `bash (unix shell)` à disposition

* Outillage:
  * Installez Java - JDK 8 (nous avons testé le lab avec la version `1.8.0_162-b12` et `openjdk version "1.8.0_161"`)
  * Venez avec votre IDE/`vi` préféré, peu nous importe ;)
  * Installez Maven (nous avons testé le lab avec `Apache Maven 3.3.9` et `Apache Maven 3.5.0 (Red Hat 3.5.0-6)`)
  * Installez docker (nous avons testé la version `18.04.0-ce-rc2` et `1.13.1, build caba767-unsupported`)
  * Installez docker-compose (nous avons testé la version `1.20.1` et `1.17.1, build 6d101fb`)
  * Installez OpenSSL (nous avons testé avec `OpenSSL 1.0.1p 9 Jul 2015`)

Pour plus de comfort durant le lab et ne pas souffir des aléas du réseau du palais des congrès, lancer les commandes suivantes à l'avance:

  * dans votre terminal clonez ce repo: `git clone https://github.com/francoisledroff/la_barbe_dans_le_cambouis.git`
  * puis `cd la_barbe_dans_le_cambouis`
  * démarrez notre container keycloak: `docker-compose -f src/main/docker/keycloak.yml up`
  * construisez notre nginx en exécutant: `./src/main/docker/build-docker-image.sh`
  * construisez notre container mongo en exécutant: `docker build -t mongo src/main/docker/mongo/`
  * construisez notre bonne vieille application Java (et télecharger internet pour satisfaire maven): `./mvnw clean install` ou `mvn clean install`

