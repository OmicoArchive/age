package me.omico.age.settings

import me.omico.age.settings.internal.VariablesDelegate
import org.gradle.api.initialization.Settings
import org.gradle.kotlin.dsl.create

interface AutoModuleCreationExtension {
    val currentPath: String
    val variables: MutableMap<String, String>
    fun include(module: String, template: String)
}

open class AutoModuleCreationExtensionImpl : AutoModuleCreationExtension {

    override val currentPath: String = ""

    override val variables: MutableMap<String, String> = mutableMapOf()

    override fun include(module: String, template: String) =
        AutoModuleCreationFolderBuilder(currentPath, variables).include(module, template)

    companion object {

        fun create(settings: Settings): AutoModuleCreationExtension = run {
            AutoModuleCreationConfigs.settings = settings
            AutoModuleCreationConfigs.templatesFolder = settings.rootDir.resolve("templates")
            settings.extensions.create("autoModuleCreation", AutoModuleCreationExtensionImpl::class)
        }
    }
}

var AutoModuleCreationExtension.name: String by VariablesDelegate

var AutoModuleCreationExtension.group: String by VariablesDelegate

var AutoModuleCreationExtension.sourceType: String by VariablesDelegate
