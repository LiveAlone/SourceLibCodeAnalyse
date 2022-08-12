
plugins {
    id("org.yqj.source.java-common-conventions")
}

publishing {
    publications {
        getByName<MavenPublication>("maven") {
            pom {
                description.set("org yqj source tool info")
            }
        }
    }
}

dependencies {
    implementation("cglib:cglib:3.2.4")
    implementation("org.apache.commons:commons-pool2:2.11.1")
}