import me.omico.age.dsl.withKotlinDsl
import me.omico.age.dsl.withKotlinMavenPublication

plugins {
    `kotlin-dsl`
}

subprojects {
    group = "me.omico.age.settings"
    withKotlinMavenPublication(mavenPublicationName = "gradlePlugin")
    withKotlinDsl {
        dependencies {
            compileOnly(gradleApi())
            compileOnly(gradleKotlinDsl())
        }
    }
}

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
    implementation(projects.ageGradlePlugin.settings.autoModuleCreation)
    implementation(projects.ageGradlePlugin.settings.commonVersionCatalogs)
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(gradleKotlinDsl())
}
