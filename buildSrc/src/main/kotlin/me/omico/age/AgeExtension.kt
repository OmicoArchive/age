package me.omico.age

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


