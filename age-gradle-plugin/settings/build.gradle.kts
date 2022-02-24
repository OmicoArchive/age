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
        register("age-settings") {
            id = "me.omico.age.settings"
            implementationClass = "me.omico.age.settings.AgeSettingsPlugin"
        }
    }
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(gradleKotlinDsl())
}
