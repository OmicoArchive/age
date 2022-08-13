plugins {
    `kotlin-dsl`
    id("age.build-logic.maven-publish")
}

dependencies {
    compileOnly(embeddedKotlin("gradle-plugin"))
    compileOnly(libs.gradle.plugin.android)
}
