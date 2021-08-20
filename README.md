### Local Database

`docker run --rm -e MYSQL_ALLOW_EMPTY_PASSWORD=true -e MYSQL_DATABASE=f1_manager -p 3305:3306 -v ${PWD}/src/main/resources/db/migration:/docker-entrypoint-initdb.d mysql:8.0.26`