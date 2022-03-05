@file:Suppress(
    "UnstableApiUsage",
    "unused",
)

package me.omico.age.settings

import org.gradle.api.initialization.Settings
import org.gradle.api.model.ObjectFactory
import javax.inject.Inject

open class CommonVersionCatalogsExtension @Inject constructor(
    private val settings: Settings,
    private val objectFactory: ObjectFactory,
) {

    fun create(namespace: String, isSnapshot: Boolean = false) =
        settings.dependencyResolutionManagement.versionCatalogs {
            val filePath = when {
                isSnapshot -> "gradle/snapshot-$namespace.versions.toml"
                else -> "gradle/common-version-catalogs/$namespace.versions.toml"
            }
            create(namespace) {
                from(objectFactory.fileCollection().from("${settings.settingsDir}/$filePath"))
            }
        }

    companion object {
        const val NAME = "commonVersionCatalogs"
    }
}

fun Settings.commonVersionCatalogs(block: CommonVersionCatalogsExtension.() -> Unit) =
    extensions.configure(CommonVersionCatalogsExtension.NAME, block)
