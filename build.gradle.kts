import com.diffplug.gradle.spotless.SpotlessExtension

plugins {
    `maven-publish`
    `kotlin-dsl`
    // https://plugins.gradle.org/plugin/com.github.ben-manes.versions
    id("com.github.ben-manes.versions") version "0.39.0"
    // https://plugins.gradle.org/plugin/com.diffplug.spotless
    id("com.diffplug.spotless") version "5.14.1"
}

group = "me.omico.age"
version = "1.0.0"

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly("com.android.tools.build:gradle:7.1.0-alpha03")
    compileOnly("com.diffplug.spotless:com.diffplug.spotless.gradle.plugin:5.14.1")
    compileOnly(gradleApi())
    compileOnly(gradleKotlinDsl())
    compileOnly(kotlin("gradle-plugin", "1.5.20"))
}

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("age") {
            groupId = group.toString()
            artifactId = "age"
            from(components["kotlin"])
        }
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

val ktlintVersion = "0.41.0"
configure<SpotlessExtension> {
    kotlin {
        target("src/**/*.kt")
        ktlint(ktlintVersion)
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    }
    kotlinGradle {
        target("**/*.gradle.kts")
        ktlint(ktlintVersion)
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    }
    format("xml") {
        target(
            "src/**/*.xml",
            ".run/*.xml",
            ".idea/runConfigurations/*.xml",
        )
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    }
}
