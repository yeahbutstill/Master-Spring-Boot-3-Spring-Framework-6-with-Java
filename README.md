# Master-Spring-Boot-3-Spring-Framework-6-with-Java

## Run MySQL Using Docker
```shell
docker run --rm \
--env MYSQL_ROOT_PASSWORD=dummypassword \
--env MYSQL_USER=todos-user \
--env MYSQL_PASSWORD=dummytodos \
--env MYSQL_DATABASE=todos \
--name mysql-todos-user \
--publish 3306:3306 \
mysql:8

docker run --rm \
--env MYSQL_ROOT_PASSWORD=dummypassword \
--env MYSQL_USER=social-media-user \
--env MYSQL_PASSWORD=dummypassword \
--env MYSQL_DATABASE=social-media-database \
--name mysql-social-media-user \
--publish 3306:3306 \
mysql:8
```

## MySQLsh Commands
```shell
docker exec -it {NAME_OF_CONTAINER} bash 
mysqlsh connect todos-user@localhost:3306 
\sql use todos; 
select * from todo;

docker exec -it {NAME_OF_CONTAINER} bash 
mysqlsh connect social-media-user@localhost:3306
\sql use social-media-database;
select * from user_details;
select * from posting;
```

## Swagger
```http request
localhost:8080/swagger-ui.html
```

## H2
```http request
localhost:8080/h2-console
```