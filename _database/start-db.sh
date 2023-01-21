#! /bin/bash

docker run --name ftgo-database-dev --rm \
   -p 3306:3306 \
   -e MYSQL_USER=mysqluser \
   -e MYSQL_PASSWORD=mysqlpw \
   -e MYSQL_ROOT_PASSWORD=mysqlrootpw \
   mysql:latest