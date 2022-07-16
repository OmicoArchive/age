package me.omico.age.settings.internal

import me.omico.age.settings.ModuleStructureConfigs
import me.omico.age.settings.ModuleStructureExtension
import me.omico.age.settings.group
import me.omico.age.settings.name
import me.omico.age.settings.sourceType
import me.omico.age.settings.template
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.absolutePathString
import kotlin.io.path.createDirectories
import kotlin.io.path.exists
import kotlin.io.path.isDirectory
import kotlin.io.path.isRegularFile
import kotlin.io.path.readText
import kotlin.io.path.writeText

fun ModuleStructureExtension.createTemplate(module: String) {
    val settings = ModuleStructureConfigs.settings
    val moduleDirectory: Path = settings.rootDir.toPath()
        .resolve(currentPath.removePrefix(":").replace(":", File.separator))
        .resolve(module)
    moduleDirectory.createDirectories()
    val moduleSourceDirectory: Path = moduleDirectory.resolve("src")
    if (!moduleSourceDirectory.exists()) moduleSourceDirectory.resolve("main").also {
        it.createDirectories()
        sourceType.ifNotNullOrEmpty { sourceType ->
            it.resolve(sourceType).createDirectories()
            group.ifNotNullOrEmpty { group ->
                it.resolve(sourceType).resolve(group.replace(".", File.separator)).createDirectories()
            }
        }
    }
    copyTemplates(moduleDirectory)
    settings.include("$currentPath:$module")
}

private fun ModuleStructureExtension.copyTemplates(moduleDirectory: Path) {
    val templateDictionary = ModuleStructureConfigs.templatesFolder.toPath().resolve(template)
    val templateDictionaryString = templateDictionary.absolutePathString()
    Files.walk(templateDictionary).forEach {
        if (it == templateDictionary) return@forEach
        val target = targetPath(moduleDirectory, templateDictionaryString, it)
        if (target.exists()) return@forEach
        when {
            it.isRegularFile() -> target.writeText(variables.resolveContent(it.readText()))
            it.isDirectory() -> target.createDirectories()
        }
    }
}

private fun ModuleStructureExtension.targetPath(
    moduleDirectory: Path,
    templateDictionary: String,
    template: Path,
): Path =
    template.absolutePathString()
        .replace(templateDictionary, moduleDirectory.absolutePathString())
        .let {
            when {
                it.startsWith(moduleDirectory.absolutePathString()) ->
                    it.replace("@(group)", group.replace(".", File.separator))
                        .replace("@(name)", name)
                else -> it
            }
        }
        .let(Paths::get)

fun Map<String, String>.resolveContent(content: String): String {
    var resolveContent = content
    forEach { (key, value) -> resolveContent = resolveContent.replace("@($key)", value) }
    return resolveContent
}
