package me.omico.age.dsl

import org.gradle.api.Project
import java.util.Properties

inline val Project.localProperties: Properties
    get() = Properties().apply {
        val file = project.rootProject.file("local.properties")
        if (!file.exists()) file.createNewFile()
        load(file.inputStream())
    }

fun Project.taskRequestContains(parameter: String): Boolean =
    gradle.startParameter.taskRequests.toString().toUpperCase().contains(parameter.toUpperCase())
