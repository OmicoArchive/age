@file:Suppress("UnstableApiUsage")

rootProject.name = "android-gradle-extensions"

enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    val versions = object {
        val gradleEnterprisePlugin = "3.6.3"
        val gradleVersionsPlugin = "0.39.0"
        val kotlinPlugin = "1.5.31"
        val spotlessPlugin = "5.17.0"
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
