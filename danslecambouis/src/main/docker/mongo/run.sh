docker run \
    --publish 28018:28018 \
    --volume $PWD/config:/etc/mongo \
    --name mongodb \
    mongo
