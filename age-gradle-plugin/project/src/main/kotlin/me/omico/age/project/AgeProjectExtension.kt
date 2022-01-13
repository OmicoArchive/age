@file:Suppress("unused")

package me.omico.age.project

import me.omico.age.dsl.withAndroidApplication
import me.omico.age.dsl.withAndroidDynamicFeature
import me.omico.age.dsl.withAndroidLibrary
import org.gradle.api.Project

abstract class AgeProjectExtension {

    fun Project.onAndroidModule(block: (type: AndroidModuleType) -> Unit) {
        withAndroidApplication { block(AndroidModuleType.Application) }
        withAndroidLibrary { block(AndroidModuleType.Library) }
        withAndroidDynamicFeature { block(AndroidModuleType.DynamicFeature) }
    }

    companion object {

        const val NAME = "age"
    }
}
