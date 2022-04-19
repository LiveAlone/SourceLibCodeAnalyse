
plugins {
    id("org.yqj.source.java-common-conventions")
}

publishing {
    publications {
        getByName<MavenPublication>("maven") {
            pom {
                description.set("org yqj source engine info")
            }
        }
    }
}

dependencies {
    implementation("com.alibaba:QLExpress:3.2.0")
}