### docker shell
1. network
  ```shell script
    docker network ls;
    docker network create bear-net
  ```

```shell script
passwd:xpalive/123456789
passwd:root/123456789

scp /c/word/test.txt root@172.22.247.176:/home 
```

### redis
conf sample : https://raw.githubusercontent.com/redis/redis/6.0/redis.conf
```shell script
docker run -d \
--name redis01 \
--network bear-net \
-v /data/redis/conf:/usr/local/etc/redis \
-v /data/redis/data:/data \
-p 6379:6379 \
--restart=on-failure:3 \
redis:6.2.4 redis-server /usr/local/etc/redis/redis.conf
```

/usr/local/etc/redis/redis.conf
参数修改
```shell script
bind
port
dir
dbfilename
appendfilename
requirepass
daemonize  使用docker时必须为no否则docker无法启动
```

### mysql
```shell script
docker run -d \
--name mysql01 \
--network bear-net \
-e MYSQL_ROOT_PASSWORD=123456789 \
-e MYSQL_ROOT_HOST=% \
-e TZ=Asia/Shanghai \
-v /data/mysql/datadir:/var/lib/mysql \
-v /data/mysql/log:/var/log/mysql \
-v /data/mysql/conf.d:/etc/mysql/conf.d \
-v /data/mysql/mysql.conf.d:/etc/mysql/mysql.conf.d \
-p 3306:3306 \
--restart=on-failure:3 \
mysql:5.7.34
```


### mongo
```shell script
docker run -d \
--name mongo01 \
--network bear-net \
-v /data/mongo/datadir:/data/db \
-v /data/mongo/conf:/etc/mongo \
-e MONGO_INITDB_ROOT_USERNAME=mongoadmin \
-e MONGO_INITDB_ROOT_PASSWORD=secret \
-p 27017:27017 \
--restart=on-failure:3 \
mongo:4.4.6
```

### nginx
```shell script
docker run -d \
--name nginx \
--network bear-net \
-v /data/nginx/log:/var/log/nginx:rw \
-v /data/nginx/conf.d:/etc/nginx/conf.d:rw \
-v /data/nginx/html:/usr/share/nginx/html:ro \
-p 80:80 \
--restart=on-failure:3 \
nginx:1.21.0
```