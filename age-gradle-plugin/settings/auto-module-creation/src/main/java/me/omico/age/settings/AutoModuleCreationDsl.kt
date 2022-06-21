@file:Suppress(
    "UnusedReceiverParameter",
    "unused",
)

package me.omico.age.settings

import org.gradle.api.initialization.Settings
import org.gradle.kotlin.dsl.configure

fun Settings.autoModuleCreation(block: AutoModuleCreationExtension.() -> Unit) = extensions.configure(block)

fun AutoModuleCreationExtension.configs(block: AutoModuleCreationConfigs.() -> Unit) =
    AutoModuleCreationConfigs.apply(block)

fun AutoModuleCreationExtension.folder(name: String, builder: AutoModuleCreationFolderBuilder.() -> Unit) =
    AutoModuleCreationFolderBuilder("$currentPath:$name").apply(builder)
