### docker shell
1. network
  ```shell script
    docker network ls;
    docker network create bear-net
  ```


### redis
conf sample : https://raw.githubusercontent.com/redis/redis/6.0/redis.conf
```shell script
docker run --name redis01 \
--network bear-net \
-v /data/redis/conf:/usr/local/etc/redis \
-v /data/redis/data:/data \
-p 6379:6379 \
-d --restart=on-failure:3 redis:6.2.4 \
redis-server /usr/local/etc/redis/redis.conf
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

### mongo

### nginx