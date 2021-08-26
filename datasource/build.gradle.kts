/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("org.yqj.source.java-common-conventions")
}

publishing {
    publications {
        getByName<MavenPublication>("maven") {
            pom {
                description.set("org yqj source datasource info")
            }
        }
    }
}

dependencies {
    // https://mvnrepository.com/artifact/mysql/mysql-connector-java
    implementation("mysql:mysql-connector-java:8.0.26")

    // https://mvnrepository.com/artifact/com.zaxxer/HikariCP
    implementation("com.zaxxer:HikariCP:5.0.0")

    // https://mvnrepository.com/artifact/com.alibaba/druid
    implementation("com.alibaba:druid:1.2.6")
}