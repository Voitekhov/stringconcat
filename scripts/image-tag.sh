#!/bin/sh

GIT_TAG=$(git rev-parse --verify HEAD)
GIT_BRANCH=$(git rev-parse --abbrev-ref HEAD)
echo $GIT_BRANCH-$GIT_TAG
