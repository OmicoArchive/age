@file:Suppress("unused")

package me.omico.age.spotless

import com.diffplug.gradle.spotless.FormatExtension
import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin
import com.diffplug.spotless.kotlin.KtLintStep
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import java.io.File

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
    targets: List<String> = listOf("src/**/*.kt"),
    excludeTargets: List<String> = listOf(),
    ktLintVersion: String = KtLintStep.defaultVersion(),
    editorConfig: Map<String, String> = defaultEditorConfig,
    licenseHeaderFile: File? = null,
    licenseHeaderConfig: FormatExtension.LicenseHeaderConfig.() -> Unit = {},
) = kotlin {
    target(targets)
    targetExclude(excludeTargets)
    ktlint(ktLintVersion)
        .editorConfigOverride(editorConfig)
    licenseHeaderFile?.let(::licenseHeaderFile)?.apply(licenseHeaderConfig)
}

fun SpotlessExtension.kotlinGradle(
    targets: List<String> = listOf("**/*.gradle.kts"),
    excludeTargets: List<String> = listOf(),
    ktLintVersion: String = KtLintStep.defaultVersion(),
    editorConfig: Map<String, String> = defaultEditorConfig,
) = kotlinGradle {
    target(targets)
    targetExclude(excludeTargets)
    ktlint(ktLintVersion)
        .editorConfigOverride(editorConfig)
}

fun SpotlessExtension.protobuf(
    clangFormatVersion: String = "13.0.0",
    style: String = "Google",
    block: FormatExtension.() -> Unit = {
        target("src/**/*.proto")
        clangFormat(clangFormatVersion).style(style)
    },
) = format("protobuf", block)

val defaultEditorConfig: Map<String, String> = mapOf(
    "disabled_rules" to "argument-list-wrapping" +
        "," + "filename",
    "ij_kotlin_allow_trailing_comma" to "true",
    "ij_kotlin_allow_trailing_comma_on_call_site" to "true",
)
