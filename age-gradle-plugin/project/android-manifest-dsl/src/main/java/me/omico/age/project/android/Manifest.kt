package me.omico.age.project.android

import me.omico.age.project.android.manifest.handleAttributesNamespace
import me.omico.age.project.xml.Builder
import me.omico.age.project.xml.ElementBuilder
import me.omico.age.project.xml.ElementScope

interface ManifestScope : ElementScope

fun manifest(function: ManifestScope.() -> Unit): String = ManifestBuilder().apply(function).build()

internal class ManifestBuilder(
    private val elementBuilder: ElementBuilder = ElementBuilder(name = "manifest"),
) : ManifestScope,
    ElementScope by elementBuilder,
    Builder<String> {
    override fun build(): String = run {
        handleAttributesNamespace()
        elementBuilder.build().toString()
    }
}
