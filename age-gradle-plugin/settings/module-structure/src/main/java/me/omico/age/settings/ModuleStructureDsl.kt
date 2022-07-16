@file:Suppress(
    "UnusedReceiverParameter",
    "unused",
)

package me.omico.age.settings

import me.omico.age.settings.internal.FolderBuilder
import me.omico.age.settings.internal.resolveVariables
import org.gradle.api.initialization.Settings
import org.gradle.kotlin.dsl.configure

fun Settings.moduleStructure(block: ModuleStructureExtension.() -> Unit) = extensions.configure(block)

fun ModuleStructureExtension.configs(block: ModuleStructureConfigs.() -> Unit) =
    ModuleStructureConfigs.apply(block)

/**
 * Create a folder for this project. You can also nest folders infinitely.
 *
 * Example:
 * ```
 * folder("<folder-name>") {
 *     module("<module-name>") {
 *         template = "<template>"
 *     }
 *     folder("<another-folder-name>") {
 *
 *     }
 * }
 * ```
 *
 * @param name The module name.
 * @param builder Other configurations for this folder.
 *
 */
fun ModuleStructureExtension.folder(
    name: String,
    builder: ModuleStructureExtension.() -> Unit,
): ModuleStructureExtension =
    FolderBuilder(
        currentPath = "$currentPath:$name",
        variables = resolveVariables(name),
    ).apply(builder)

/**
 * Create a module from a template and include it in this project.
 * If the module already exists, it will only include in this project.
 *
 * Note: this method should only be used when the parent declares a template.
 *
 *
 * Example:
 * ```
 * folder("<folder-name>") {
 *     template = "<template>" // Must be set. Otherwise, won't take effect.
 *     module("<module-name>")
 * }
 * ```
 *
 * @param name The module name.
 *
 */
fun ModuleStructureExtension.module(name: String): ModuleStructureExtension =
    apply { module(name) {} }

/**
 * Quickly create a module from a template without other configurations and include it in this project.
 * If the module already exists, it will only include in this project.
 *
 *
 * Example:
 * ```
 * module("<folder-name>", "<module-name>")
 * ```
 *
 * @param name The module name.
 *
 */
fun ModuleStructureExtension.module(name: String, template: String): ModuleStructureExtension =
    apply { module(name) { this.template = template } }

/**
 * Set variable for this destination, e.g. folder/module.
 *
 *
 * Example:
 * ```
 * // Usage in Settings:
 * folder("<folder-name>") {
 *     variable("text", "hello")
 *     folder("<another-folder-name>") {
 *         variable("text", "world") // Will override the parent one. But only for this and its children.
 *     }
 * }
 *
 * // Usage in template:
 * // For example in settings.gradle.kts:
 * val text = "@(text)" // Will be replaced @(text) with "hello" or "world".
 * println(text)
 * ```
 *
 * @param name The module name.
 *
 */
fun <T : Any> ModuleStructureExtension.variable(name: String, value: T) =
    variables.put(name, value.toString())
