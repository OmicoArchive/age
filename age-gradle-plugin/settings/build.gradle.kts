plugins {
    `kotlin-dsl`
    id("age.build-logic.maven-publish")
}

subprojects {
    group = "me.omico.age.settings"
}

gradlePlugin {
    plugins {
        register("age-settings") {
            id = "me.omico.age.settings"
            implementationClass = "me.omico.age.settings.AgeSettingsPlugin"
        }
    }
}

dependencies {
    subprojects.forEach(::implementation)
}
