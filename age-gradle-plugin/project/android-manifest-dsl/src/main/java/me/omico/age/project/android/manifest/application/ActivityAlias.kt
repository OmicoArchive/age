@file:Suppress("FunctionName")

package me.omico.age.project.android.manifest.application

import me.omico.age.project.android.manifest.AndroidAttributesDelegate
import me.omico.age.project.android.manifest.ApplicationScope
import me.omico.age.project.xml.ElementBuilder
import me.omico.age.project.xml.ElementScope

interface ActivityAliasScope : ElementScope

fun ApplicationScope.`activity-alias`(builder: ActivityAliasScope.() -> Unit) =
    +ActivityAliasBuilder().apply(builder).build()

fun ApplicationScope.`activity-alias`(name: String, builder: ActivityAliasScope.() -> Unit = {}) =
    `activity-alias` {
        this.name = name
        builder()
    }

var ActivityAliasScope.name: String by AndroidAttributesDelegate()

internal class ActivityAliasBuilder : ActivityAliasScope, ElementBuilder("activity-alias")
