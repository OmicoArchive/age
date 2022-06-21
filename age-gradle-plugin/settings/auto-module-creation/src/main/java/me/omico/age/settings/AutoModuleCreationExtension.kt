package me.omico.age.settings

import org.gradle.api.initialization.Settings
import org.gradle.kotlin.dsl.create

interface AutoModuleCreationExtension {
    val currentPath: String
    fun include(module: String, template: String)
}

open class AutoModuleCreationExtensionImpl : AutoModuleCreationExtension {

    override val currentPath: String = ""

    override fun include(module: String, template: String) =
        AutoModuleCreationFolderBuilder(currentPath).include(module, template)

    companion object {

        fun create(settings: Settings): AutoModuleCreationExtension = run {
            AutoModuleCreationConfigs.settings = settings
            AutoModuleCreationConfigs.templatesFolder = settings.rootDir.resolve("templates")
            settings.extensions.create("autoModuleCreation", AutoModuleCreationExtensionImpl::class)
        }
    }
}
