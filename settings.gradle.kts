@file:Suppress("UnstableApiUsage")

rootProject.name = "android-gradle-extensions"

enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    val versions = object {
        val gradleEnterprisePlugin = "3.6.3" // https://plugins.gradle.org/plugin/com.gradle.enterprise
        val gradleVersionsPlugin = "0.39.0" // https://plugins.gradle.org/plugin/com.github.ben-manes.versions
        val kotlinPlugin = "1.5.21"
        val spotlessPlugin = "5.14.2" // https://plugins.gradle.org/plugin/com.diffplug.spotless
    }
    plugins {
        id("com.diffplug.spotless") version versions.spotlessPlugin
        id("com.github.ben-manes.versions") version versions.gradleVersionsPlugin
        id("com.gradle.enterprise") version versions.gradleEnterprisePlugin
        id("org.jetbrains.kotlin.jvm") version versions.kotlinPlugin
    }
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
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

include(":age-dsl")
include(":age-gradle-plugin")
