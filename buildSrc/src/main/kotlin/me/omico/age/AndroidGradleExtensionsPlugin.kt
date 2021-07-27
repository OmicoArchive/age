package me.omico.age

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

class AndroidGradleExtensionsPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.extensions.create<AgeExtension>(AgeExtension.NAME)
    }
}
