
plugins {
    id("org.yqj.source.java-library-conventions")
}

publishing {
    publications {
        getByName<MavenPublication>("maven") {
            pom {
                description.set("org yqj source init info")
            }
        }
    }
}