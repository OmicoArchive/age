plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(embeddedKotlin("gradle-plugin"))
    implementation(libs.bundles.dsl)
    implementation(libs.gradle.plugin.versions)
}
