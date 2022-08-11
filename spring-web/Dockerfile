# 构建运行时刻镜像内容
FROM openjdk:17
COPY build/libs/spring-web-1.0.0.jar /tmp
WORKDIR /tmp
EXPOSE 8080
CMD java -jar spring-web-1.0.0.jar