import me.omico.age.dsl.withKotlinDsl
import me.omico.age.dsl.withKotlinMavenPublication

plugins {
    `kotlin-dsl`
}

subprojects {
    group = "me.omico.age.settings"
    withKotlinMavenPublication(mavenPublicationName = "gradlePlugin")
    withKotlinDsl {
        kotlin {
            target {
                compilations.all {
                    kotlinOptions {
                        freeCompilerArgs = listOf(
                            "-Xopt-in=kotlin.RequiresOptIn",
                        )
                    }
                }
            }
        }
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
    implementation(projects.ageGradlePlugin.settings.commonVersionCatalogs)
    implementation(projects.ageGradlePlugin.settings.moduleStructure)
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(gradleKotlinDsl())
}
