rootProject.name = "android-gradle-extensions"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("com.android.application") version "7.1.0-alpha04"
        id("com.android.library") version "7.1.0-alpha04"
        id("com.diffplug.spotless") version "5.14.2"
        id("com.gradle.enterprise") version "3.6.3"
        id("org.jetbrains.kotlin.android") version "1.5.10"
        id("org.jetbrains.kotlin.jvm") version "1.5.10"
        id("com.github.ben-manes.versions") version "0.39.0"
        id("org.gradle.kotlin.kotlin-dsl") version "2.1.6"
    }
}

dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

plugins {
    id("com.gradle.enterprise")
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishAlways()
    }
}

include(":age-gradle-plugin")
