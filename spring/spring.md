
## spring 项目test

* spring basic
    - ServerLifecycleBean bean 自定义对象生命周期
    - ApplicationEventPublisher app 上下文Jvm 内部事件推送
    - SpringCache spring接口拦截，集成不同Cache 缓存拦截工具

* Spring Cache

  - jsr 对Cache 接口的定义 ```javax.cache:cache-api:1.1.1```
  - spring 自定义Cache 依赖模块定义

```gradle
    implementation("org.springframework.boot:spring-boot-starter-cache")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    
    # 依赖 jackson 序列化方式
    implementation("com.fasterxml.jackson.core:jackson-core")
    implementation("com.fasterxml.jackson.core:jackson-databind")
```

Spring 支持 ConcurrentHashMap, Jedis, MemCache 等等不同缓存资源， 通过RedisCacheExample
