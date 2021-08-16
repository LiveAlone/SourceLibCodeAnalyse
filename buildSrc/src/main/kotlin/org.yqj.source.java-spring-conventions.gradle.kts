/*
 * spring 依赖初始化
 */

plugins {
    java
    // todo spring plugin how to combine user definition
//    id("org.springframework.boot") version ("2.2.3.RELEASE") apply false
//    id("io.spring.dependency-management") version ("1.0.10.RELEASE") apply false
}

repositories {
    mavenCentral()
}

//dependencies {
//
//    compileOnly("org.projectlombok:lombok")
//    annotationProcessor("org.projectlombok:lombok")
//
//    testCompileOnly("org.projectlombok:lombok")
//    testAnnotationProcessor("org.projectlombok:lombok")
//
//     guava
//    implementation("com.google.guava:guava")
//}