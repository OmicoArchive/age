plugins {
    `kotlin-dsl`
}

kotlin {
    target {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
}

dependencies {
    implementation(embeddedKotlin("gradle-plugin"))
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
    implementation(libs.bundles.dsl)
}
