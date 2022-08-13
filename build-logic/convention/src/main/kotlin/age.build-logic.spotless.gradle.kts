import me.omico.age.spotless.configureSpotless
import me.omico.age.spotless.gradleVersionCatalogs
import me.omico.age.spotless.intelliJIDEARunConfiguration
import me.omico.age.spotless.kotlin
import me.omico.age.spotless.kotlinGradle

plugins {
    id("age.build-logic.root-project.base")
    id("com.diffplug.spotless")
}

allprojects {
    configureSpotless {
        gradleVersionCatalogs()
        intelliJIDEARunConfiguration()
        kotlin()
        kotlinGradle()
    }
}
