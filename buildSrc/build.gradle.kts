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
    implementation(versionCatalogs.named("libs").findBundle("dsl").get())
}
