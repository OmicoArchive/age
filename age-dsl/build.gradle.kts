import me.omico.age.dsl.withKotlinMavenPublication

plugins {
    `kotlin-dsl`
}

withKotlinMavenPublication(mavenPublicationName = "dsl")

dependencies {
    compileOnly(embeddedKotlin("gradle-plugin"))
    compileOnly(gradleApi())
    compileOnly(gradleKotlinDsl())
    compileOnly(libs.gradle.plugin.android)
}
