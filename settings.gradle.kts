@file:Suppress("UnstableApiUsage")

rootProject.name = "android-gradle-extensions"

enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    val versions = object {
        val gradleEnterprisePlugin = "3.8"
        val gradleVersionsPlugin = "0.41.0"
        val kotlinPlugin = "1.6.10"
        val spotlessPlugin = "6.2.0"
    }
    plugins {
        id("com.diffplug.spotless") version versions.spotlessPlugin
        id("com.github.ben-manes.versions") version versions.gradleVersionsPlugin
        id("com.gradle.enterprise") version versions.gradleEnterprisePlugin
        kotlin("jvm") version versions.kotlinPlugin
    }
    repositories {
        gradlePluginPortal()
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
include(":age-gradle-plugin:project")
include(":age-gradle-plugin:settings")
include(":age-gradle-plugin:spotless")
