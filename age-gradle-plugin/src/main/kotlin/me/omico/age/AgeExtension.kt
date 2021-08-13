@file:Suppress("unused")

package me.omico.age

import me.omico.age.dsl.withAndroidApplication
import me.omico.age.dsl.withAndroidDynamicFeature
import me.omico.age.dsl.withAndroidLibrary
import org.gradle.api.Project

abstract class AgeExtension {

    fun Project.onAndroidModule(block: (type: AndroidModuleType) -> Unit) {
        withAndroidApplication { block(AndroidModuleType.Application) }
        withAndroidLibrary { block(AndroidModuleType.Library) }
        withAndroidDynamicFeature { block(AndroidModuleType.DynamicFeature) }
    }

    companion object {

        const val NAME = "age"
    }
}
