package me.omico.age.project.android.manifest.application

import me.omico.age.project.android.manifest.AndroidAttributesDelegate
import me.omico.age.project.android.manifest.ApplicationScope
import me.omico.age.project.android.manifest.AttributeKeys
import me.omico.age.project.android.manifest.requireAndroidAttribute
import me.omico.age.project.xml.Element
import me.omico.age.project.xml.ElementBuilder
import me.omico.age.project.xml.ElementScope

interface ActivityScope : ElementScope

// TODO activity, service, provider

fun ApplicationScope.activity(builder: ActivityScope.() -> Unit) = +ActivityBuilder().apply(builder).build()

fun ApplicationScope.activity(name: String, builder: ActivityScope.() -> Unit = {}) =
    activity {
        this.name = name
        builder()
    }

var ActivityScope.name: String by AndroidAttributesDelegate()

internal class ActivityBuilder : ActivityScope, ElementBuilder("activity") {
    override fun build(): Element = super.build()
        .also { it.requireAndroidAttribute(AttributeKeys.NAME) }
}
