plugins {
    id("java")
    id("com.adarshr.test-logger") version "3.2.0"
    application
}

group = "objektwerks"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("objektwerks.App")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("ch.qos.logback:logback-classic:1.2.11")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}