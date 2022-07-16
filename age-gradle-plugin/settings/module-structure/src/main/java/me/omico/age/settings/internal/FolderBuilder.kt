package me.omico.age.settings.internal

import me.omico.age.settings.ModuleStructureExtension
import me.omico.age.settings.template
import org.gradle.api.Action

internal data class FolderBuilder(
    override val currentPath: String,
    override val variables: MutableMap<String, String>,
) : ModuleStructureExtension {
    override fun module(name: String, action: Action<ModuleStructureExtension>) {
        with(copy(variables = resolveVariables(name)).apply(action::execute)) {
            when {
                template.isNullOrEmpty ->
                    println("$currentPath:$name: You must declare a template for this module. Otherwise, it won't take effect.")
                else -> createTemplate(name)
            }
        }
    }
}
