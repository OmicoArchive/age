@file:Suppress("unused")

package me.omico.age.dsl

import com.diffplug.gradle.spotless.FormatExtension
import com.diffplug.gradle.spotless.KotlinExtension
import com.diffplug.gradle.spotless.KotlinGradleExtension
import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

fun Project.configureSpotless(block: SpotlessExtension.() -> Unit) {
    apply<SpotlessPlugin>()
    plugins.withId("com.diffplug.spotless") { configure(block) }
}

private const val DEFAULT_KT_LINT_VERSION = "0.42.1"

fun Project.configureSpotlessWithCommonRules() =
    configureSpotless {
        androidXml()
        gradleVersionCatalogs()
        intelliJIDEARunConfiguration()
        kotlin()
        kotlinGradle()
    }

fun SpotlessExtension.androidXml(
    block: FormatExtension.() -> Unit = {},
) = format("androidXml") {
    target(
        "**/AndroidManifest.xml",
        "src/**/*.xml",
    )
    indentWithSpaces()
    trimTrailingWhitespace()
    endWithNewline()
    block()
}

fun SpotlessExtension.gradleVersionCatalogs(
    block: FormatExtension.() -> Unit = {},
) = format("gradleVersionCatalogs") {
    target(
        "**/*.versions.toml",
    )
    indentWithSpaces()
    trimTrailingWhitespace()
    endWithNewline()
    block()
}

fun SpotlessExtension.intelliJIDEARunConfiguration(
    block: FormatExtension.() -> Unit = {},
) = format("intelliJIDEARunConfiguration") {
    target(
        ".run/*.xml",
        ".idea/runConfigurations/*.xml",
    )
    indentWithSpaces()
    trimTrailingWhitespace()
    endWithNewline()
    block()
}

fun SpotlessExtension.kotlin(
    ktLintVersion: String = DEFAULT_KT_LINT_VERSION,
    block: KotlinExtension.() -> Unit = {},
) = kotlin {
    target("src/**/*.kt")
    ktlint(ktLintVersion)
    indentWithSpaces()
    trimTrailingWhitespace()
    endWithNewline()
    block()
}

fun SpotlessExtension.kotlinGradle(
    ktLintVersion: String = DEFAULT_KT_LINT_VERSION,
    block: KotlinGradleExtension.() -> Unit = {},
) = kotlinGradle {
    target("**/*.gradle.kts")
    ktlint(ktLintVersion)
    indentWithSpaces()
    trimTrailingWhitespace()
    endWithNewline()
    block()
}
