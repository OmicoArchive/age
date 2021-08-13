@file:Suppress("UnstableApiUsage")

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

pluginManager.withPlugin("org.gradle.kotlin.kotlin-dsl") {
    val catalogs = extensions.getByType<VersionCatalogsExtension>()
    val libs = catalogs.named("libs")
    dependencies {
        implementation(gradleApi())
        implementation(gradleKotlinDsl())
        implementation(libs.findDependency("gradle-plugin-android").get())
        implementation(libs.findDependency("gradle-plugin-kotlin").get())
        implementation(libs.findDependency("gradle-plugin-spotless").get())
    }
}
