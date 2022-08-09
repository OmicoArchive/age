@file:Suppress(
    "FunctionName",
    "UnusedReceiverParameter",
)

package me.omico.age.project.android.manifest

import me.omico.age.project.android.ManifestScope
import me.omico.age.project.xml.Element
import me.omico.age.project.xml.ElementScope
import me.omico.age.project.xml.element

fun androidElement(elementName: String, name: String, builder: ElementScope.() -> Unit = {}): Element =
    element(elementName) {
        androidAttribute(AttributeKeys.NAME, name)
        builder()
    }

fun ManifestScope.permission(permission: String, protectionLevel: String) =
    +androidElement("permission", permission) {
        androidAttribute("protectionLevel", protectionLevel)
    }

fun ManifestScope.`uses-permission`(permission: String) =
    +androidElement("uses-permission", permission)

fun ManifestScope.`uses-permission-sdk-23`(permission: String, maxSdkVersion: Int) =
    +androidElement("uses-permission-sdk-23", permission) {
        androidAttribute("maxSdkVersion", maxSdkVersion)
    }

fun ManifestScope.`uses-feature`(feature: String, required: Boolean = true) =
    +androidElement("uses-feature", feature) {
        if (!required) androidAttribute(AttributeKeys.REQUIRED, false)
    }

fun ManifestScope.`supports-screens`(
    anyDensity: Boolean = false,
    normalScreens: Boolean = false,
    largeScreens: Boolean = false,
    xlargeScreens: Boolean = false,
) = +element("supports-screens") {
    if (anyDensity) androidAttribute("anyDensity", true)
    if (normalScreens) androidAttribute("normalScreens", true)
    if (largeScreens) androidAttribute("largeScreens", true)
    if (xlargeScreens) androidAttribute("xlargeScreens", true)
}
