plugins {
    `java-gradle-plugin`
    id("org.gradle.kotlin.kotlin-dsl") version "2.1.6"
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

gradlePlugin {
    plugins {
        register("androidGradleExtensions") {
            id = "me.omico.age"
            implementationClass = "me.omico.age.AndroidGradleExtensionsPlugin"
        }
    }
}

dependencies {
    implementation("com.android.tools.build:gradle:7.1.0-alpha05")
    implementation("com.diffplug.spotless:com.diffplug.spotless.gradle.plugin:5.14.2")
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
    implementation(kotlin("gradle-plugin", "1.5.10"))
    implementation(kotlin("reflect", "1.5.10"))
    implementation(kotlin("stdlib", "1.5.10"))
}
