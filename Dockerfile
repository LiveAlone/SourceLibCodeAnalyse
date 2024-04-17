# buid
FROM eclipse-temurin:21-jdk-jammy as builder

WORKDIR /build

# 复制构建文件
COPY buildSrc buildSrc
COPY settings.gradle.kts gradlew ./
COPY gradle/ gradle/
COPY spring-web spring-web/

RUN ./gradlew build


### 部署
FROM eclipse-temurin:21-jre-jammy as final

# 设置工作目录
WORKDIR /app

# 复制编译好的 JAR 文件到容器中
COPY --from=builder /build/spring-web/build/libs/spring-web.jar /app/myapp.jar

## 指定容器启动时执行的命令
CMD ["java", "-jar", "myapp.jar"]