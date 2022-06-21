package me.omico.age.settings

import org.gradle.api.initialization.Settings
import java.io.File

interface AutoModuleCreationConfigs {
    var templatesFolder: File
    var defaultTemplate: String?

    companion object : AutoModuleCreationConfigs {

        internal lateinit var settings: Settings

        override var templatesFolder: File = File("templates")
        override var defaultTemplate: String? = null
    }
}
