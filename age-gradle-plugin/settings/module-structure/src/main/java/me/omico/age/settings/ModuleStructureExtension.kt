package me.omico.age.settings

import me.omico.age.settings.internal.VariablesDelegate
import org.gradle.api.Action

interface ModuleStructureExtension {
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
    fun module(name: String, action: Action<ModuleStructureExtension>)
}

var ModuleStructureExtension.name: String by VariablesDelegate

var ModuleStructureExtension.group: String by VariablesDelegate

var ModuleStructureExtension.sourceType: String by VariablesDelegate

var ModuleStructureExtension.template: String by VariablesDelegate
