package me.omico.age.project.android.manifest

import me.omico.age.project.android.ManifestScope
import me.omico.age.project.xml.ElementBuilder
import me.omico.age.project.xml.ElementScope

interface QueriesScope : ElementScope

fun ManifestScope.queries(function: QueriesScope.() -> Unit) = +QueriesBuilder().apply(function).build()

fun QueriesScope.intent(function: IntentScope.() -> Unit) = +IntentBuilder().apply(function).build()

fun QueriesScope.`package`(name: String) = +androidElement("package", name)

internal class QueriesBuilder : QueriesScope, ElementBuilder("queries")
