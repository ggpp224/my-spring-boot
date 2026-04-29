#!/bin/sh
# AI 生成 By Peng.Guo

set -euf

BASE_DIR=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
WRAPPER_JAR="$BASE_DIR/.mvn/wrapper/maven-wrapper.jar"
WRAPPER_PROPERTIES="$BASE_DIR/.mvn/wrapper/maven-wrapper.properties"

if [ ! -f "$WRAPPER_JAR" ]; then
  echo "Cannot find $WRAPPER_JAR" >&2
  exit 1
fi

if [ ! -f "$WRAPPER_PROPERTIES" ]; then
  echo "Cannot find $WRAPPER_PROPERTIES" >&2
  exit 1
fi

JAVA_EXEC="${JAVA_HOME:-}/bin/java"
if [ ! -x "$JAVA_EXEC" ]; then
  JAVA_EXEC="java"
fi

exec "$JAVA_EXEC" \
  -Dmaven.multiModuleProjectDirectory="$BASE_DIR" \
  -classpath "$WRAPPER_JAR" \
  org.apache.maven.wrapper.MavenWrapperMain "$@"
