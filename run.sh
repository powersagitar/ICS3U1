#!/bin/zsh

path_to_java_src=$1

if [[ ! -v "${path_to_java_src}" ]]; then
    echo "Path to java source file not provided."
    exit
fi

if [[ ! -f "./init-rs" ]]; then
    ./init.sh
fi

./init-rs $path_to_java_src

docker buildx build -t java-image-temp .
docker run -it --rm java-image-temp
