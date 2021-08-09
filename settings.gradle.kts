rootProject.name = "android-gradle-extensions"

pluginManagement {
    val versions = object {
        val androidGradlePlugin = "7.1.0-alpha06"
        val gradleEnterprisePlugin = "3.6.3" // https://plugins.gradle.org/plugin/com.gradle.enterprise
        val gradleVersionsPlugin = "0.39.0" // https://plugins.gradle.org/plugin/com.github.ben-manes.versions
        val kotlinDslPlugin = "2.1.6"
        val kotlinPlugin = "1.5.21"
        val spotlessPlugin = "5.14.2" // https://plugins.gradle.org/plugin/com.diffplug.spotless
    }
    plugins {
        id("com.android.application") version versions.androidGradlePlugin
        id("com.android.library") version versions.androidGradlePlugin
        id("com.diffplug.spotless") version versions.spotlessPlugin
        id("com.github.ben-manes.versions") version versions.gradleVersionsPlugin
        id("com.gradle.enterprise") version versions.gradleEnterprisePlugin
        id("org.gradle.kotlin.kotlin-dsl") version versions.kotlinDslPlugin
        id("org.jetbrains.kotlin.android") version versions.kotlinPlugin
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

include(":age-gradle-plugin")
