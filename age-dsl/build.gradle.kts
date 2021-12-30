@file:Suppress("UnstableApiUsage")

import me.omico.age.dsl.javaCompatibility
import me.omico.age.dsl.withKotlinMavenPublication

plugins {
    `kotlin-dsl`
}

javaCompatibility(all = JavaVersion.VERSION_11)
withKotlinMavenPublication(mavenPublicationName = "dsl")

dependencies {
    compileOnly(gradleApi())
    compileOnly(gradleKotlinDsl())
    versionCatalogs {
        compileOnly(named("libs").findBundle("dsl").get())
    }
}
