mongo \
    --ssl \
    --sslCAFile ./config/ssl/server.pem \
    --sslPEMKeyFile ./config/ssl/client.pem \
    --sslPEMKeyPassword admin \
    --host localhost \
    --port 28018
