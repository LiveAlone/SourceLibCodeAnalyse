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
                description.set("org yqj source resilience4j info")
            }
        }
    }
}

dependencies {
    implementation("com.alibaba.csp:sentinel-core:1.8.4")
    implementation("com.alibaba.csp:sentinel-transport-simple-http:1.8.4")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
}