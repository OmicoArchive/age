package me.omico.age.settings

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings
import org.gradle.kotlin.dsl.create

class CommonVersionCatalogsPlugin : Plugin<Settings> {

    override fun apply(target: Settings) {
        target.extensions.create<CommonVersionCatalogsExtension>(CommonVersionCatalogsExtension.NAME, target)
    }
}
