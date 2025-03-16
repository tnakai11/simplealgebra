plugins {
    kotlin("jvm") version "2.1.10"
}

group = "dev.tnakai11"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))  // Kotlin Test library
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3") // JUnit 5
}

tasks.test {
    useJUnitPlatform()
}