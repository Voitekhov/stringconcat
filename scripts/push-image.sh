#!/bin/bash
set -e

CURRENT_DIR=$(cd -P -- "$(dirname -- "$0")" && pwd -P)

IMAGE_FULL_NAME=$("$CURRENT_DIR"/image-full-name.sh)

echo [Main app STARTING] pushing image "$IMAGE_FULL_NAME"...
echo [Main app] pushing image...

docker push "$IMAGE_FULL_NAME"

echo [Main app FINISHED] image "$IMAGE_FULL_NAME" pushed
