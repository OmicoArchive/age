@file:Suppress("unused")

package me.omico.age.dsl

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.withKotlin(block: Plugin<in Any>.() -> Unit) {
    plugins.withId("kotlin", block)
    withKotlinAndroid(block)
}

fun Project.withKotlinAndroid(block: Plugin<in Any>.() -> Unit) =
    plugins.withId("kotlin-android", block)

fun Project.kotlinCompile(block: KotlinCompile.() -> Unit) =
    withKotlin { tasks.withType<KotlinCompile>().configureEach(block) }
