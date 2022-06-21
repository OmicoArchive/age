package me.omico.age.settings

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

class AutoModuleCreationPlugin : Plugin<Settings> {
    override fun apply(target: Settings) {
        AutoModuleCreationExtensionImpl.create(target)
    }
}
