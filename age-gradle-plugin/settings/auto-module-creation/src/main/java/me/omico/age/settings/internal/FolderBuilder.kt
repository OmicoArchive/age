package me.omico.age.settings.internal

import me.omico.age.settings.AutoModuleCreationExtension
import me.omico.age.settings.template
import org.gradle.api.Action

internal data class FolderBuilder(
    override val currentPath: String,
    override val variables: MutableMap<String, String>,
) : AutoModuleCreationExtension {
    override fun module(name: String, action: Action<AutoModuleCreationExtension>) {
        with(copy(variables = resolveVariables(name)).apply(action::execute)) {
            when {
                template.isNullOrEmpty ->
                    println("$currentPath:$name: You must declare a template for this module. Otherwise, it won't take effect.")
                else -> createTemplate(name)
            }
        }
    }
}
