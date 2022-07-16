package me.omico.age.settings.internal

import me.omico.age.settings.ModuleStructureConfigs
import me.omico.age.settings.ModuleStructureExtension
import org.gradle.api.Action
import org.gradle.api.initialization.Settings
import org.gradle.kotlin.dsl.create

internal open class ModuleStructureExtensionImpl : ModuleStructureExtension {

    override val currentPath: String = ""

    override val variables: MutableMap<String, String> = mutableMapOf()

    override fun module(name: String, action: Action<ModuleStructureExtension>) =
        FolderBuilder(currentPath, variables).module(name, action)

    companion object {

        fun create(settings: Settings): ModuleStructureExtension = run {
            ModuleStructureConfigs.settings = settings
            ModuleStructureConfigs.templatesFolder = settings.rootDir.resolve("templates")
            settings.extensions.create("autoModuleCreation", ModuleStructureExtensionImpl::class)
        }
    }
}
