# Master-Spring-Boot-3-Spring-Framework-6-with-Java

## Run MySQL Using Docker
```shell
docker run --rm \
--env MYSQL_ROOT_PASSWORD=dummypassword \
--env MYSQL_USER=todos-user \
--env MYSQL_PASSWORD=dummytodos \
--env MYSQL_DATABASE=todos \
--name mysql \
--publish 3306:3306 \
mysql:8
```

## MySQLsh Commands
```shell
docker exec -it {NAME_OF_CONTAINER} bash 
mysqlsh connect todos-user@localhost:3306 
\sql use todos; 
select * from todo;
```