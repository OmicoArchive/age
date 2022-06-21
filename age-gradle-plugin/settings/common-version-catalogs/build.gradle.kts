import me.omico.age.dsl.withKotlinMavenPublication

plugins {
    `kotlin-dsl`
}

withKotlinMavenPublication(mavenPublicationName = "gradlePlugin")

dependencies {
    compileOnly(gradleApi())
    compileOnly(gradleKotlinDsl())
}
