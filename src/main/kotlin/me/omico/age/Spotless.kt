@file:Suppress("unused")

package me.omico.age

import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

fun Project.configureSpotlessWithCommonRules(
    ktlintVersion: String = "0.41.0"
) {
    plugins.withId("com.diffplug.spotless") {
        configure<SpotlessExtension> {
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
}
