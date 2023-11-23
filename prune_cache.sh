#!/bin/zsh

echo "Erasing:"
rm -vrf ./Dockerfile
rm -vrf ./init-rs

docker system prune