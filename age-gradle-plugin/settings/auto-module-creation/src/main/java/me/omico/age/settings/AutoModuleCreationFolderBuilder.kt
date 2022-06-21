package me.omico.age.settings

class AutoModuleCreationFolderBuilder(
    override val currentPath: String,
) : AutoModuleCreationExtension {

    override fun include(module: String, template: String) {
        AutoModuleCreator.create("$currentPath:$module", template)
    }
}
