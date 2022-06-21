import me.omico.age.dsl.javaCompatibility
import me.omico.age.dsl.withKotlinMavenPublication

plugins {
    `kotlin-dsl`
}

subprojects {
    group = "me.omico.age.settings"
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
    implementation(projects.ageGradlePlugin.settings.commonVersionCatalogs)
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(gradleKotlinDsl())
}
