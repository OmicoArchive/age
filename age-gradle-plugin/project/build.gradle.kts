plugins {
    `kotlin-dsl`
    id("age.build-logic.maven-publish")
}

gradlePlugin {
    plugins {
        register("age-project") {
            id = "me.omico.age.project"
            implementationClass = "me.omico.age.project.AgeProjectPlugin"
        }
    }
}

dependencies {
    api(projects.ageDsl)
    implementation(projects.ageGradlePlugin.project.mavenPublish)
}
