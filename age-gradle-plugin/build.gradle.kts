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
        register("androidGradleExtensions") {
            id = "me.omico.age"
            implementationClass = "me.omico.age.AndroidGradleExtensionsPlugin"
        }
    }
}

dependencies {
    api(project(":age-dsl"))
}
