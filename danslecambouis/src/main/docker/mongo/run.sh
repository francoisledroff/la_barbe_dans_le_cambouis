docker run \
    --publish 28018:28018 \
    --volume /Users/ledroff/workspace/github/la_barbe_dans_le_cambouis/danslecambouis/src/main/docker/mongo/config:/etc/mongo \
    --name mongodb \
    mongo
