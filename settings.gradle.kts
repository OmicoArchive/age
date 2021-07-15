rootProject.name = "android-gradle-extensions"

plugins {
    // https://plugins.gradle.org/plugin/com.gradle.enterprise
    id("com.gradle.enterprise") version "3.6.3"
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishAlways()
    }
}
