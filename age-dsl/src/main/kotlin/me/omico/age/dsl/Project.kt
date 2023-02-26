package me.omico.age.dsl

import org.gradle.api.Project

fun Project.taskRequestContains(parameter: String): Boolean =
    gradle.startParameter.taskRequests.toString().uppercase().contains(parameter.uppercase())
