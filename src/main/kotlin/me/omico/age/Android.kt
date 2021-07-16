@file:Suppress("UnstableApiUsage", "unused")

package me.omico.age

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

fun Project.withAndroidApplication(block: Plugin<in Any>.() -> Unit) =
    plugins.withId("com.android.application", block)

fun Project.withAndroidLibrary(block: Plugin<in Any>.() -> Unit) =
    plugins.withId("com.android.library", block)

fun Project.withAndroidDynamicFeature(block: Plugin<in Any>.() -> Unit) =
    plugins.withId("com.android.dynamic-feature", block)

fun Project.withAndroid(block: Plugin<in Any>.() -> Unit) {
    withAndroidApplication(block)
    withAndroidLibrary(block)
    withAndroidDynamicFeature(block)
}

fun Project.configureAndroidCommon(block: CommonExtension<*, *, *, *>.() -> Unit) =
    withAndroid { configure("android", block) }
