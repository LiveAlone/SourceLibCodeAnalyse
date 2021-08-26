/*
 * spring 依赖初始化
 */

plugins {
    id("org.yqj.source.java-spring-conventions")
}

publishing {
    publications {
        getByName<MavenPublication>("maven") {
            pom {
                description.set("org yqj source spring web info")
            }
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}

