#!/bin/bash

sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout src/main/docker/nginx-config/keys/server-key.key -out src/main/docker/nginx-config/keys/certificate.crt
