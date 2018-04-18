#!/bin/bash

readonly DOCKERFILE=${1:-'src/main/docker/nginx.dockerfile'}
readonly CONTAINER_NAME=${2:'nginx-rp:latest'}
readonly ROOT_DIR=${2:-'src/main/docker/'}

docker build -f "${DOCKERFILE}" -t "${CONTAINER_NAME}" "${ROOT_DIR}"
