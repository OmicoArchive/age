@file:Suppress(
    "UnusedReceiverParameter",
    "unused",
)

package me.omico.age.settings

import me.omico.age.settings.internal.resolveVariables
import org.gradle.api.initialization.Settings
import org.gradle.kotlin.dsl.configure

fun Settings.autoModuleCreation(block: AutoModuleCreationExtension.() -> Unit) = extensions.configure(block)

fun AutoModuleCreationExtension.configs(block: AutoModuleCreationConfigs.() -> Unit) =
    AutoModuleCreationConfigs.apply(block)

fun AutoModuleCreationExtension.folder(
    name: String,
    builder: AutoModuleCreationFolderBuilder.() -> Unit,
): AutoModuleCreationFolderBuilder =
    AutoModuleCreationFolderBuilder(
        currentPath = "$currentPath:$name",
        variables = resolveVariables(name),
    ).apply(builder)

fun <T : Any> AutoModuleCreationExtension.variable(name: String, value: T) =
    variables.put(name, value.toString())
