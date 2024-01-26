#!/bin/bash

set -e

CURRENT_DIR=$(cd -P -- "$(dirname -- "$0")" && pwd -P)
ROOT_DIR="$CURRENT_DIR/../"
IMAGE_FULL_NAME=$("$CURRENT_DIR"/image-full-name.sh)


echo [Application] creating jar...
(cd "$ROOT_DIR" && exec ./gradlew bootJar --no-daemon)

echo [Application] build docker image...

(exec docker build -t "$IMAGE_FULL_NAME" .)

echo [Application] image name "$IMAGE_FULL_NAME"

echo [Application] start docker compose
(cd "$CURRENT_DIR"/docker/app && IMAGE_NAME="$IMAGE_FULL_NAME" docker-compose up -d)
