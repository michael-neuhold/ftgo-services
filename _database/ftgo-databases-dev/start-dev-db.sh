#! /bin/bash

docker run --name ftgo-consumer-database-dev --rm \
   -d \
   -p 3306:3306 \
   -e MYSQL_DATABASE=consumer-db \
   -e MYSQL_USER=mysqluser \
   -e MYSQL_PASSWORD=mysqlpw \
   -e MYSQL_ROOT_PASSWORD=mysqlrootpw \
   mysql:latest

docker run --name ftgo-courier-database-dev --rm \
   -d \
   -p 3307:3306 \
   -e MYSQL_DATABASE=courier-db \
   -e MYSQL_USER=mysqluser \
   -e MYSQL_PASSWORD=mysqlpw \
   -e MYSQL_ROOT_PASSWORD=mysqlrootpw \
   mysql:latest