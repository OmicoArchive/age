import me.omico.age.dsl.withKotlinMavenPublication

plugins {
    `kotlin-dsl`
}

withKotlinMavenPublication(mavenPublicationName = "gradlePlugin")

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
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(gradleKotlinDsl())
}
