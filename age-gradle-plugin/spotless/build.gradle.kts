plugins {
    `kotlin-dsl`
    id("age.build-logic.maven-publish")
}

gradlePlugin {
    plugins {
        register("age-spotless") {
            id = "me.omico.age.spotless"
            implementationClass = "me.omico.age.spotless.AgeSpotlessPlugin"
        }
    }
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(gradleKotlinDsl())
    compileOnly(libs.gradle.plugin.spotless)
}
