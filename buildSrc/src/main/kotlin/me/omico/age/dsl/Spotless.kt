@file:Suppress("unused")

package me.omico.age.dsl

import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

fun Project.configureSpotless(block: SpotlessExtension.() -> Unit) =
    plugins.withId("com.diffplug.spotless") { configure(block) }

fun Project.configureSpotlessWithCommonRules(
    ktlintVersion: String = "0.41.0",
) = configureSpotless {
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
