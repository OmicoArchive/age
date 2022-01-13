@file:Suppress("unused")

package me.omico.age.project

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

class AgeProjectPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.extensions.create<AgeProjectExtension>(AgeProjectExtension.NAME)
    }
}
