## skywalking 

初始化配置上下文，客户端参考链接 (https://skywalking.apache.org/docs/skywalking-java/latest/en/setup/service-agent/java-agent/readme/)

服务端默认sit 测试地址: [address](10.4.44.91:11800)

启动命令添加
```javascript
# SIT环境
# java -javaagent:/data/skywalking/skywalking-agent/skywalking-agent.jar -Dskywalking.agent.service_name=dolphin -jar Main.java
# 在启动命令-jar之前，添加如下配置代码：
- '-javaagent:/Users/yaoqijun/skywalking/skywalking-agent/skywalking-agent.jar'
- '-Dskywalking.agent.service_name=$(APPID)'
- '-Dskywalking.collector.backend_service=10.4.44.91:11800'
```

监控插件
