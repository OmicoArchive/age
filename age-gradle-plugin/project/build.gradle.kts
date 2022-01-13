import me.omico.age.dsl.javaCompatibility
import me.omico.age.dsl.withKotlinMavenPublication

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

javaCompatibility(all = JavaVersion.VERSION_11)
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
    api(project(":age-dsl"))
}
