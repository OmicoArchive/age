plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(embeddedKotlin("gradle-plugin"))
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
    implementation(libs.bundles.dsl)
}
