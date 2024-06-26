/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("org.yqj.source.java-spring-conventions")
}

dependencies{
    implementation("org.redisson:redisson:3.28.0")
}

publishing {
    publications {
        getByName<MavenPublication>("maven") {
            pom {
                description.set("org yqj source spring info")
            }
        }
    }
}