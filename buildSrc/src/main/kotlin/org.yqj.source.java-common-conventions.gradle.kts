import org.gradle.api.publish.maven.internal.publisher.MavenLocalPublisher

plugins {
    java
    `maven-publish`
}

repositories {
    // Use Maven Central for resolving dependencies.
    maven {
        url = uri("https://maven.aliyun.com/nexus/content/groups/public")
    }
}

// 版本定义
val guavaVersion = "31.1-jre"

dependencies {

    // lombok
    compileOnly("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")

    // guava
    implementation("com.google.guava:guava:$guavaVersion")

    // log
    implementation("ch.qos.logback:logback-core:1.2.3")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("org.slf4j:slf4j-api:1.7.30")

    ///////////////////////////
    ////////// test
    ///////////////////////////

    // junit
    testImplementation("junit:junit:4.13.2")

    // lombok
    testCompileOnly("org.projectlombok:lombok:1.18.20")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.20")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            pom {
                description.set("yqj source comment info")
                developers {
                    developer {
                        id.set("yqj")
                        name.set("yaoqijun")
                        email.set("yaoqijunmail@foxmail.com")
                    }
                }
            }
        }
    }
}
