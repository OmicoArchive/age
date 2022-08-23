@file:Suppress("UnstableApiUsage")

import me.omico.age.dsl.gradle

gradle.beforeSettings {
    buildscript.configurations.all {
        resolutionStrategy.cacheChangingModulesFor(0, TimeUnit.SECONDS)
    }
}

gradle.settingsEvaluated {
    pluginManagement {
        repositories {
            gradle()
        }
    }
}

dependencyResolutionManagement {
    repositories {
        gradle()
    }
}
