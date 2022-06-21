package me.omico.age.settings

import java.io.File

object AutoModuleCreator {

    fun create(module: String, template: String) {
        val settings = AutoModuleCreationConfigs.settings
        var dir = settings.rootDir
        module.split(":").forEach { dir = dir.resolve(it) }
        dir.resolve("src").mkdirs()
        dir.copyTemplates(template)
        settings.include(module)
    }

    private fun File.copyTemplates(template: String) {
        val templateFiles = AutoModuleCreationConfigs.templatesFolder
            .resolve(template).listFiles() ?: return
        templateFiles.forEach {
            val targetFile = resolve(it.name)
            if (targetFile.exists()) return
            it.copyTo(targetFile)
        }
    }
}
