import me.omico.age.dsl.configureMavenLibraryPublish

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `maven-publish`
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    withSourcesJar()
}

gradlePlugin {
    plugins {
        register("androidGradleExtensions") {
            id = "me.omico.age"
            implementationClass = "me.omico.age.AndroidGradleExtensionsPlugin"
        }
    }
}

dependencies {
    api(project(":age-dsl"))
}

configureMavenLibraryPublish(
    mavenPublicationName = "gradlePlugin",
    versionName = version.toString(),
)
