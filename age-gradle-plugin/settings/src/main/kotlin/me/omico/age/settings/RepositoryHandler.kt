@file:Suppress("unused")

package me.omico.age.settings

import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.maven

fun RepositoryHandler.androidxSnapshots(buildID: Int = 0) {
    if (buildID == 0) return
    maven(url = "https://androidx.dev/snapshots/builds/$buildID/artifacts/repository")
}

fun RepositoryHandler.jetbrainsCompose() {
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

fun RepositoryHandler.nexusSnapshots() {
    maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots")
}
