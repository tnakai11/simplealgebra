plugins {
    kotlin("jvm") version "2.1.10"
    id("org.jlleitschuh.gradle.ktlint") version "12.2.0"
}

group = "dev.tnakai11"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test")) // Kotlin Test library
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3") // JUnit 5
}

tasks.test {
    useJUnitPlatform()
}

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    version.set("1.5.0")
}
