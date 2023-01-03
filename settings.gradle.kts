@file:Suppress("UnstableApiUsage")

rootProject.name = "age"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
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
    id("com.gradle.enterprise") version "3.12.1"
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
include(":age-gradle-plugin:project:maven-publish")
include(":age-gradle-plugin:settings")
include(":age-gradle-plugin:settings:common-version-catalogs")
include(":age-gradle-plugin:settings:initialization")
include(":age-gradle-plugin:settings:module-structure")
include(":age-gradle-plugin:spotless")
