
plugins {
    id("org.yqj.source.java-common-conventions")
}

apply<GreetingPlugin>()

publishing {
    publications {
        getByName<MavenPublication>("maven") {
            pom {
                description.set("org yqj source init info")
            }
        }
    }
}