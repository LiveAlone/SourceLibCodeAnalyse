
* spring web 项目test

    - web tomcat 上下文兼容测试

Docker 容器构建方式
```shell
./gradlew build  # 项目构建方式

docker build -t yaoqijun/spring-web:1.0.0 .  # 镜像构建方式

docker -dp 8080:8080 yaoqijun/spring-web:1.0.0 --name spring-web  # 命令行运行方式



```
  
