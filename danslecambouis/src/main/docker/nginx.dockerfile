FROM registry.fedoraproject.org/f26/s2i-base:latest

RUN dnf update -y && dnf install -y nginx
