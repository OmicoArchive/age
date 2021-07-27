import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin

buildscript {
    extra["group"] = "me.omico.age"
    extra["version"] = "1.0.0"
}

plugins {
    id("com.diffplug.spotless")
    id("com.github.ben-manes.versions")
}

allprojects {
    configureSpotless()
}

fun Project.configureSpotless() {
    apply<SpotlessPlugin>()
    configure<SpotlessExtension> {
        val ktlintVersion = "0.41.0"
        kotlin {
            target("src/**/*.kt")
            ktlint(ktlintVersion)
            indentWithSpaces()
            trimTrailingWhitespace()
            endWithNewline()
        }
        kotlinGradle {
            target("**/*.gradle.kts")
            ktlint(ktlintVersion)
            indentWithSpaces()
            trimTrailingWhitespace()
            endWithNewline()
        }
        format("xml") {
            target(
                "src/**/*.xml",
                ".run/*.xml",
                ".idea/runConfigurations/*.xml",
            )
            indentWithSpaces()
            trimTrailingWhitespace()
            endWithNewline()
        }
    }
}
