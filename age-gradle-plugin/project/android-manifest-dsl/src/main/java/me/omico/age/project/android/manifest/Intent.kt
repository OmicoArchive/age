package me.omico.age.project.android.manifest

import me.omico.age.project.xml.ElementBuilder
import me.omico.age.project.xml.ElementScope
import me.omico.age.project.xml.element

interface IntentScope : ElementScope

fun IntentScope.action(action: String) = +androidElement("action", action)

fun IntentScope.category(category: String) = +androidElement("category", category)

fun IntentScope.data(data: String) =
    +element("data") {
        androidAttribute(AttributeKeys.SCHEMA, data)
    }

internal class IntentBuilder : IntentScope, ElementBuilder("intent")
