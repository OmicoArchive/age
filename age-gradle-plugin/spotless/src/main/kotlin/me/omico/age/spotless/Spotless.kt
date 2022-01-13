@file:Suppress("unused")

package me.omico.age.spotless

import com.diffplug.gradle.spotless.FormatExtension
import com.diffplug.gradle.spotless.KotlinExtension
import com.diffplug.gradle.spotless.KotlinGradleExtension
import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin
import com.diffplug.spotless.kotlin.KtLintStep
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

fun Project.configureSpotless(block: SpotlessExtension.() -> Unit) {
    apply<SpotlessPlugin>()
    plugins.withId("com.diffplug.spotless") { configure(block) }
}

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
    ktLintVersion: String = KtLintStep.defaultVersion(),
    block: KotlinExtension.() -> Unit = {
        target("src/**/*.kt")
        ktlint(ktLintVersion)
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    },
) = kotlin(block)

fun SpotlessExtension.kotlinGradle(
    ktLintVersion: String = KtLintStep.defaultVersion(),
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
