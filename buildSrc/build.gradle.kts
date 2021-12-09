@file:Suppress("UnstableApiUsage")

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
    versionCatalogs {
        implementation(named("libs").findBundle("dsl").get())
    }
}
