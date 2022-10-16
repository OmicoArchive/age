@file:Suppress("unused")

package me.omico.age.dsl

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import java.io.File
import java.util.Properties

fun Project.configureAppSigningConfigsForRelease(
    properties: Properties = localProperties,
) = plugins.withId("com.android.application") {
    if (hasNullSigningConfigProperties(properties)) return@withId
    configure<BaseExtension>("android") {
        signingConfigs {
            create("release") {
                storeFile = file(properties["store.file"] as String)
                storePassword = properties["store.password"] as String
                keyAlias = properties["key.alias"] as String
                keyPassword = properties["key.password"] as String
            }
        }
    }
}

private fun Project.hasNullSigningConfigProperties(properties: Properties): Boolean {
    val nullProperties = listOf("store.file", "store.password", "key.alias", "key.password")
        .mapNotNull { if (properties[it] == null) it else null }
    val hasNullProperties = nullProperties.isNotEmpty()
    if (hasNullProperties) {
        println(
            "========================== Notice ==========================\n" +
                "You should set $nullProperties in your properties file. \n" +
                "Otherwise this signingConfig will not be applied.\n" +
                "The default properties file is ${rootDir}${File.separator}local.properties.\n" +
                "============================================================",
        )
    }
    return hasNullProperties
}
