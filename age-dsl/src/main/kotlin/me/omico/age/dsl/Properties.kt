package me.omico.age.dsl

import org.gradle.api.Project
import java.util.Properties

inline val Project.localProperties: Properties
    get() = Properties().apply {
        val file = project.rootProject.file("local.properties")
        if (!file.exists()) file.createNewFile()
        load(file.inputStream())
    }

fun Project.sensitiveProperty(name: String): String =
    localProperties.getProperty(name)
        ?: System.getenv(name)
        ?: error("Cannot find property $name in local.properties.")

inline infix fun <reified T> Project.property(name: String): T = properties[name] as T
