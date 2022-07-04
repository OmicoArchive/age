package me.omico.age.settings.internal

import me.omico.age.settings.AutoModuleCreationConfigs
import me.omico.age.settings.AutoModuleCreationExtension
import me.omico.age.settings.group
import me.omico.age.settings.sourceType
import me.omico.age.settings.template
import java.io.File

fun AutoModuleCreationExtension.createTemplate(module: String) {
    val settings = AutoModuleCreationConfigs.settings
    var dir = settings.rootDir
    currentPath.split(":").forEach { dir = dir.resolve(it) }
    dir = dir.resolve(module)
    val srcDir = dir.resolve("src")
    if (!srcDir.exists()) srcDir.resolve("main").let {
        it.mkdirs()
        sourceType.ifNotNullOrEmpty { sourceType ->
            it.resolve(sourceType).mkdirs()
            group.ifNotNullOrEmpty { group ->
                it.resolve(sourceType).resolve(group.replace(".", File.separator)).mkdirs()
            }
        }
    }
    dir.copyTemplates(template, variables)
    settings.include("$currentPath:$module")
}

private fun File.copyTemplates(template: String, variables: Map<String, String>) {
    val templateFiles = AutoModuleCreationConfigs.templatesFolder.resolve(template).listFiles() ?: return
    templateFiles.forEach { templateFile ->
        val targetFile = resolve(templateFile.name)
        if (targetFile.exists()) return
        templateFile.readText().let {
            var content = it
            variables.forEach { (key, value) -> content = content.replace("@($key)", value) }
            return@let content
        }.let { targetFile.writeText(it) }
    }
}
