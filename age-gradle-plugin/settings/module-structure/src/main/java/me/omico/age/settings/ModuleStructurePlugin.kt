package me.omico.age.settings

import me.omico.age.settings.internal.ModuleStructureExtensionImpl
import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

class ModuleStructurePlugin : Plugin<Settings> {
    override fun apply(target: Settings) {
        ModuleStructureExtensionImpl.create(target)
    }
}
