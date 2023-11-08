#!/bin/zsh

if [[ ! -f "Main.java" ]]; then
    echo 'Java source file not found'
    echo 'The java source file has to be named as Main.java'
    exit
fi

docker buildx build -t java-image-temp .
docker run -it --rm java-image-temp
