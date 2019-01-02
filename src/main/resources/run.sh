#!/bin/bash
fullpath=`readlink -f $0`
basedir=`dirname "${fullpath}"`
echo "Application base path:" $basedir
echo "Exporting..."
export APP_BASE=$basedir

java -cp ".:$basedir/*" -Dlogback.configurationFile=$basedir/logback.xml  my.learnings.logging.logback.HelloWorld1
