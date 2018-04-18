## Mongo ssl server and client cert

To secure data transportation, you need to generate two SSL certificates for MongoDB 
— one for the server, and one for the client that will access the database.

    Note: We create self-signed certificates in this tutorial. 
    In a production environment, you would use a trusted certificate authority to generate them.
    To do that, you need to set up a private DNS resolver. 
    Then, use the Let's Encrypt DNS challenge to validate the newly-created intranet domains 
    and issue certificates for them.

Find out the IP of your mongo containerized server using the command:

    docker ps -q \
    | xargs docker inspect --format '{{ .Id }} \
    - {{ .Name }} - {{ .NetworkSettings.IPAddress }}'
    
You'll get something like this:

    e4a8b604ee6caefd7dfb67efa4fa856ad7366e06adf5c0fdf5c3e3e49f0f2c50 \
    - /mongodb - 172.17.0.2

First, generate the server certificate-key pair. 
Fill in the prompts with information of your choice. Pay attention to the Common Name and PEM Passphrase fields.

    openssl req -new -x509 -days 365 -out server.crt -keyout server.key
      
When prompted for the `Common Name / FQDN` use `localhost`

MongoDB does not accept separate key and certificate files, so combine them into a single .pem file:

    cat server.crt server.key >> server.pem

Next, generate the certificate-key pair for the client:

    openssl req -new -x509 -days 365 -out client.crt -keyout client.key

When prompted for the `Common Name / FQDN` use `localhost`

Concatenate the files you just generated into a single .pem file:

    cat client.crt client.key >> client.pem


## Configure Java Client For SSL

Create a new Java trust store in the local application's root directory, importing the certificate generated from the previous section. This is necessary because in this example a self-signed certificate is used.

    $ keytool -import -alias "mongo-client-cert" -file "client.crt" -keystore truststore.ts -noprompt -storepass "supersecret"
    $ keytool -list -keystore truststore.ts -storepass supersecret
    
    