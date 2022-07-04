package me.omico.age.settings

import me.omico.age.settings.internal.FolderBuilder
import me.omico.age.settings.internal.VariablesDelegate
import org.gradle.api.Action
import org.gradle.api.initialization.Settings
import org.gradle.kotlin.dsl.create

interface AutoModuleCreationExtension {
    val currentPath: String
    val variables: MutableMap<String, String>

    /**
     * Create a module from a template and include it in this project.
     * If the module already exists, it will only include in this project.
     *
     * Example:
     * ```
     * module("<name>") {
     *     group = "com.example.project"
     *     sourceType = "kotlin"
     *     template = "<template>"
     * }
     * ```
     *
     * @param name The module name.
     * @param action Other configurations for the module.
     *
     */
    fun module(name: String, action: Action<AutoModuleCreationExtension>)
}

open class AutoModuleCreationExtensionImpl : AutoModuleCreationExtension {

    override val currentPath: String = ""

    override val variables: MutableMap<String, String> = mutableMapOf()

    override fun module(name: String, action: Action<AutoModuleCreationExtension>) =
        FolderBuilder(currentPath, variables).module(name, action)

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

var AutoModuleCreationExtension.template: String by VariablesDelegate
