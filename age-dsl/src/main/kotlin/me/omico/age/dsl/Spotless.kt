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

private const val DEFAULT_KT_LINT_VERSION = "0.43.2"

fun SpotlessExtension.androidXml(
    block: FormatExtension.() -> Unit = {
        target(
            "**/AndroidManifest.xml",
            "src/**/*.xml",
        )
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    },
) = format("androidXml", block)

fun SpotlessExtension.gradleVersionCatalogs(
    block: FormatExtension.() -> Unit = {
        target(
            "**/*.versions.toml",
        )
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    },
) = format("gradleVersionCatalogs", block)

fun SpotlessExtension.intelliJIDEARunConfiguration(
    block: FormatExtension.() -> Unit = {
        target(
            ".run/*.xml",
            ".idea/runConfigurations/*.xml",
        )
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    },
) = format("intelliJIDEARunConfiguration", block)

fun SpotlessExtension.kotlin(
    ktLintVersion: String = DEFAULT_KT_LINT_VERSION,
    block: KotlinExtension.() -> Unit = {
        target("src/**/*.kt")
        ktlint(ktLintVersion)
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    },
) = kotlin(block)

fun SpotlessExtension.kotlinGradle(
    ktLintVersion: String = DEFAULT_KT_LINT_VERSION,
    block: KotlinGradleExtension.() -> Unit = {
        target("**/*.gradle.kts")
        ktlint(ktLintVersion)
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    },
) = kotlinGradle(block)

fun SpotlessExtension.protobuf(
    clangFormatVersion: String = "13.0.0",
    style: String = "Google",
    block: FormatExtension.() -> Unit = {
        target("src/**/*.proto")
        clangFormat(clangFormatVersion).style(style)
    },
) = format("protobuf", block)
