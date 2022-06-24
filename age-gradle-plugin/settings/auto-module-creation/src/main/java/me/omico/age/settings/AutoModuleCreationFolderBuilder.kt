package me.omico.age.settings

import me.omico.age.settings.internal.createTemplate
import me.omico.age.settings.internal.resolveVariables

class AutoModuleCreationFolderBuilder(
    override val currentPath: String,
    override val variables: MutableMap<String, String>,
) : AutoModuleCreationExtension {

    override fun include(module: String, template: String) = createTemplate(module, template, resolveVariables(module))
}
