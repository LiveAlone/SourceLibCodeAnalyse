/*
 * spring 依赖初始化
 */

plugins {
    java
    id("org.springframework.boot")
    `maven-publish`
}

apply(plugin = "io.spring.dependency-management")

repositories {
    mavenCentral()
}

dependencies {

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    implementation("com.google.guava:guava:30.1-jre")
    implementation("org.springframework.boot:spring-boot-starter")

    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            pom {
                description.set("yqj source spring info")
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
