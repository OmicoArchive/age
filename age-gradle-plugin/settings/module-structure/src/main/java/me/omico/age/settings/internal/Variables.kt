package me.omico.age.settings.internal

import me.omico.age.settings.ModuleStructureExtension
import me.omico.age.settings.group
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal object VariablesDelegate : ReadWriteProperty<ModuleStructureExtension, String> {
    override fun getValue(thisRef: ModuleStructureExtension, property: KProperty<*>): String =
        thisRef.variables[property.name] ?: "null"

    override fun setValue(thisRef: ModuleStructureExtension, property: KProperty<*>, value: String) {
        thisRef.variables[property.name] = value
    }
}

internal fun ModuleStructureExtension.resolveVariables(name: String): MutableMap<String, String> =
    mutableMapOf<String, String>().apply {
        putAll(variables)
        this["name"] = name
        this@resolveVariables.group.ifNotNullOrEmpty { this["group"] = "$it.${name.replace("-", ".")}" }
    }

internal fun String.ifNotNullOrEmpty(action: (String) -> Unit) {
    if (isNotEmpty() && this != "null") action(this)
}

internal val String.isNullOrEmpty
    get() = isEmpty() || this == "null"
