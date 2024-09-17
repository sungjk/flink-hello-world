plugins {
    kotlin("jvm") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "io.sungjk.flink"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.flink:flink-connector-base:1.20.0")
    implementation("org.apache.flink:flink-streaming-java:1.20.0")
    implementation("org.apache.flink:flink-clients:1.20.0")
    implementation("org.apache.flink:flink-connector-kafka:3.2.0-1.19")
}

tasks.shadowJar {
    archiveFileName.set("hello-world.jar")
    manifest {
        attributes["Main-Class"] = "io.sungjk.flink.Main"
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
