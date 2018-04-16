#!/bin/bash

readonly DOCKERFILE=${1:-'src/main/docker/nginx.dockerfile'}
readonly ROOT_DIR=${2:-'src/main/docker/'}

docker build -f "${DOCKERFILE}" -t nginx-rp:latest "${ROOT_DIR}"
