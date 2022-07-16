package me.omico.age.settings

import org.gradle.api.initialization.Settings
import java.io.File

interface ModuleStructureConfigs {
    var templatesFolder: File

    companion object : ModuleStructureConfigs {

        internal lateinit var settings: Settings

        override var templatesFolder: File = File("templates")
    }
}
