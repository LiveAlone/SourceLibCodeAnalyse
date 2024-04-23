# dubbo 支持 rpc 调用

### 注册中心

#### zookeeper
```shell
docker run --name local-zk --network local-dev -p 2181:2181 --restart always -d zookeeper:3.9

# 服务启动完成以后
docker run -it --rm --network local-dev zookeeper:3.9 zkCli.sh -server local-zk

# 查看注册的服务
ls /services/dubbo-springboot-demo-provider
```