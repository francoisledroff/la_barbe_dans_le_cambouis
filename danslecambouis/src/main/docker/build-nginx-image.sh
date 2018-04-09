#!/bin/bash

docker build -f src/main/docker/nginx.dockerfile -t nginx-rp:latest src/main/docker/
