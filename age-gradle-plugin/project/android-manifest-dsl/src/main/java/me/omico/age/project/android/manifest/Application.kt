package me.omico.age.project.android.manifest

import me.omico.age.project.android.ManifestScope
import me.omico.age.project.xml.ElementBuilder
import me.omico.age.project.xml.ElementScope

interface ApplicationScope : ElementScope

private var isApplicationInitialized = false
fun ManifestScope.application(function: ApplicationScope.() -> Unit) {
    require(!isApplicationInitialized) { "Application is already initialized." }
    +ApplicationBuilder().apply(function).build()
    isApplicationInitialized = true
}

internal class ApplicationBuilder : ApplicationScope, ElementBuilder(name = "application")
