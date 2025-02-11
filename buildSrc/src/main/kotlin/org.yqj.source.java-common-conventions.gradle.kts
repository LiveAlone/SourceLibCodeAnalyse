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
val guavaVersion = "33.3.0-jre"
val lombokVersion = "1.18.36"
val logbackCoreVersion = "1.5.16"
val slf4jApiVersion = "2.0.16"
var junitVersion = "4.13.2"

dependencies {

    // lombok
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    // guava
    implementation("com.google.guava:guava:$guavaVersion")

    // log
    implementation("ch.qos.logback:logback-core:$logbackCoreVersion")
    implementation("ch.qos.logback:logback-classic:$logbackCoreVersion")
    implementation("org.slf4j:slf4j-api:$slf4jApiVersion")

    ///////////////////////////
    ////////// test
    ///////////////////////////

    // junit
    testImplementation("junit:junit:$junitVersion")

    // lombok
    testCompileOnly("org.projectlombok:lombok:$lombokVersion")
    testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")
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
