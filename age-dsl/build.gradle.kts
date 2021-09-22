import me.omico.age.dsl.configureMavenLibraryPublish

plugins {
    `kotlin-dsl`
    `maven-publish`
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    withSourcesJar()
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(gradleKotlinDsl())
    compileOnly(libs.bundles.dsl)
}

configureMavenLibraryPublish(
    mavenPublicationName = "dsl",
    versionName = version.toString(),
)
