@file:Suppress("unused")

package me.omico.age

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import java.util.Properties

fun Project.configureSigningConfigs(
    name: String = "release",
    properties: Properties = localProperties
) = plugins.withId("com.android.application") {
    configure<BaseExtension>("android") {
        signingConfigs {
            create(name) {
                storeFile = file(properties["store.file"] as String)
                storePassword = properties["store.password"] as String
                keyAlias = properties["key.alias"] as String
                keyPassword = properties["key.password"] as String
            }
        }
    }
}
