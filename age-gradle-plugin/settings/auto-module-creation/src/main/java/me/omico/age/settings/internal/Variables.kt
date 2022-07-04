package me.omico.age.settings.internal

import me.omico.age.settings.AutoModuleCreationExtension
import me.omico.age.settings.group
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal object VariablesDelegate : ReadWriteProperty<AutoModuleCreationExtension, String> {
    override fun getValue(thisRef: AutoModuleCreationExtension, property: KProperty<*>): String =
        thisRef.variables[property.name] ?: "null"

    override fun setValue(thisRef: AutoModuleCreationExtension, property: KProperty<*>, value: String) {
        thisRef.variables[property.name] = value
    }
}

internal fun AutoModuleCreationExtension.resolveVariables(name: String): MutableMap<String, String> =
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
