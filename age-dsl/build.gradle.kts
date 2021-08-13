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

val sourcesJar by tasks.getting(Jar::class)

publishing {
    publications {
        create<MavenPublication>("dsl") {
            artifactId = "age-dsl"
            from(components["kotlin"])
            artifact(sourcesJar)
        }
    }
}
