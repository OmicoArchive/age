import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import me.omico.age.dsl.androidXml
import me.omico.age.dsl.configureSpotless
import me.omico.age.dsl.gradleVersionCatalogs
import me.omico.age.dsl.intelliJIDEARunConfiguration
import me.omico.age.dsl.kotlin
import me.omico.age.dsl.kotlinGradle

plugins {
    id("com.diffplug.spotless")
    id("com.github.ben-manes.versions")
}

allprojects {
    group = "me.omico.age"
    version = "1.0.0-SNAPSHOT"
    configureDependencyUpdates()
    configureSpotless {
        androidXml()
        gradleVersionCatalogs()
        intelliJIDEARunConfiguration()
        kotlin()
        kotlinGradle()
    }
}

fun Project.configureDependencyUpdates() {
    apply(plugin = "com.github.ben-manes.versions")
    tasks.withType<DependencyUpdatesTask> {
        rejectVersionIf {
            when {
                stableList.contains(candidate.group) -> isNonStable(candidate.version)
                else -> false
            }
        }
    }
}

val stableList = listOf(
    "org.jetbrains.kotlin",
)

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
