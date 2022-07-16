@file:Suppress("unused")

package me.omico.age.settings

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings
import org.gradle.kotlin.dsl.apply

class AgeSettingsPlugin : Plugin<Settings> {

    override fun apply(target: Settings) {
        target.apply<CommonVersionCatalogsPlugin>()
        target.apply<ModuleStructurePlugin>()
    }
}
