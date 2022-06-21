@file:Suppress("UnstableApiUsage")

rootProject.name = "android-gradle-extensions"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    val versions = object {
        val gradleEnterprisePlugin = "3.10.2"
        val gradleVersionsPlugin = "0.42.0"
        val spotlessPlugin = "6.7.2"
    }
    plugins {
        id("com.diffplug.spotless") version versions.spotlessPlugin
        id("com.github.ben-manes.versions") version versions.gradleVersionsPlugin
        id("com.gradle.enterprise") version versions.gradleEnterprisePlugin
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
include(":age-gradle-plugin:settings:common-version-catalogs")
include(":age-gradle-plugin:spotless")
