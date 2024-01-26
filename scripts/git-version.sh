#!/bin/sh

#get highest tag number
GIT_TAG=$(git describe --abbrev=0 --tags 2>/dev/null)
HEAD_IS_TAG=$(git describe --abbrev=0 --tags --exact-match 2>/dev/null)
if [ "$GIT_TAG" = "" ]; then
  GIT_TAG="0.0.0"
fi

if [ "$HEAD_IS_TAG" != "" ]; then
  echo $GIT_TAG
else
  VNUM1=$(echo "$GIT_TAG" | cut -d"." -f1)
  VNUM2=$(echo "$GIT_TAG" | cut -d"." -f2)
  VNUM3=$(echo "$GIT_TAG" | cut -d"." -f3)
  VNUM3=$((VNUM3 + 1))

  BRANCH_VERSION=`echo $(git rev-parse --abbrev-ref HEAD) | sed 's/[\/-]/_/g'`
  BRANCH_VERSION=`echo $BRANCH_VERSION | sed 's/A/a/g' | sed 's/B/b/g' | sed 's/C/c/g' | sed 's/D/d/g' | sed 's/E/e/g' | sed 's/F/f/g' | sed 's/G/g/g' | sed 's/H/h/g' | sed 's/I/i/g' | sed 's/J/j/g' | sed 's/K/k/g' | sed 's/L/l/g' | sed 's/M/m/g' | sed 's/N/n/g' | sed 's/O/o/g' | sed 's/P/p/g' | sed 's/Q/q/g' | sed 's/R/r/g' | sed 's/S/s/g' | sed 's/T/t/g' | sed 's/U/u/g' | sed 's/V/v/g' | sed 's/W/w/g' | sed 's/X/x/g' | sed 's/Y/y/g' | sed 's/Z/z/g'`
  BRANCH_VERSION="-$BRANCH_VERSION"

  echo $VNUM1.$VNUM2.$VNUM3$BRANCH_VERSION-SNAPSHOT
fi
