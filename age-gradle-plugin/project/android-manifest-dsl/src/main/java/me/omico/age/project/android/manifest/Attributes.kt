package me.omico.age.project.android.manifest

import me.omico.age.project.android.ManifestScope
import me.omico.age.project.xml.AttributesDelegate
import me.omico.age.project.xml.AttributesScope
import me.omico.age.project.xml.Element
import kotlin.reflect.KProperty

fun Element.hasAndroidAttribute(name: String) = attributes.containsKey("android:$name")

fun Element.requireAndroidAttribute(name: String) =
    attributes["android:$name"] ?: error("android:$name is not found in <${this.name}>")

fun <T : Any> AttributesScope.androidAttribute(key: String, value: T) {
    hasAndroidAttributes = true
    attribute("android:$key", value)
}

fun <T : Any> AttributesScope.toolsAttribute(key: String, value: T) {
    hasToolsAttributes = true
    attribute("tools:$key", value)
}

internal var hasAndroidAttributes: Boolean = false

internal var hasToolsAttributes: Boolean = false

internal fun ManifestScope.handleAttributesNamespace() {
    if (hasAndroidAttributes) attribute("xmlns:android", "http://schemas.android.com/apk/res/android")
    if (hasToolsAttributes) attribute("xmlns:tools", "http://schemas.android.com/tools")
}

internal object AttributeKeys {
    const val NAME = "name"
    const val REQUIRED = "required"
    const val SCHEMA = "scheme"
}

internal class AndroidAttributesDelegate<T> : AttributesDelegate<T>() {
    override operator fun setValue(thisRef: AttributesScope, property: KProperty<*>, value: T) {
        thisRef.androidAttribute(property.name, value.toString())
    }
}
