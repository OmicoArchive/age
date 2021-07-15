package me.omico.age

import org.gradle.api.plugins.ExtensionAware

fun <T : Any> ExtensionAware.configure(name: String, block: T.() -> Unit) =
    extensions.configure(name, block)
