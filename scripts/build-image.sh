#!/bin/bash

set -e

CURRENT_DIR=$(cd -P -- "$(dirname -- "$0")" && pwd -P)
IMAGE_FULL_NAME=$("$CURRENT_DIR"/image-full-name.sh)

echo [Main App STARTING] building "$IMAGE_FULL_NAME"...
echo [Main App] creating jar...
(exec ./gradlew bootJar --no-daemon)

echo [Main App] creating docker image with name "$IMAGE_FULL_NAME"...
docker build -t "$IMAGE_FULL_NAME" .
echo [Main App FINISHED] image hsa been built
