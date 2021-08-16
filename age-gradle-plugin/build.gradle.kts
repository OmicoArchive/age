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

publishing {
    publications {
        create<MavenPublication>("gradlePlugin") {
            artifactId = "me.omico.age.gradle.plugin"
            from(components["kotlin"])
            artifact(tasks["sourcesJar"])
        }
    }
}
