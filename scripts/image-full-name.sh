#!/bin/sh

CURRENT_DIR=$(cd -P -- "$(dirname -- "$0")" && pwd -P)
IMAGE_TAG=$("$CURRENT_DIR"/image-tag.sh)
CR_REGISTRY=crpg56a4r1oduhud1mkj
CR_REPOSITORY=recode-docker-registry
IMAGE_FULL_NAME=cr.yandex/"$CR_REGISTRY"/"$CR_REPOSITORY"/people:"$IMAGE_TAG"
echo $IMAGE_FULL_NAME
