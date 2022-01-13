@file:Suppress("UnstableApiUsage")

import me.omico.age.dsl.javaCompatibility
import me.omico.age.dsl.withKotlinMavenPublication

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

javaCompatibility(all = JavaVersion.VERSION_11)
withKotlinMavenPublication(mavenPublicationName = "gradlePlugin")

gradlePlugin {
    plugins {
        register("age-spotless") {
            id = "me.omico.age.spotless"
            implementationClass = "me.omico.age.spotless.AgeSpotlessPlugin"
        }
    }
}

dependencies {
    compileOnly(libs.gradlePlugin.spotless)
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
}
