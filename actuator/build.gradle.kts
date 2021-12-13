/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("org.yqj.source.java-spring-web-conventions")
}

publishing {
    publications {
        getByName<MavenPublication>("maven") {
            pom {
                description.set("org yqj source actuator info")
            }
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("io.micrometer:micrometer-registry-prometheus")
}