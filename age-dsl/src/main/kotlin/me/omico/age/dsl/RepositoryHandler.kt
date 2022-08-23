@file:Suppress("unused")

package me.omico.age.dsl

import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.artifacts.repositories.ArtifactRepository
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.kotlin.dsl.maven

fun RepositoryHandler.gradle(): ArtifactRepository =
    gradlePluginPortal {
        content {
            includeGroupByRegex("com.gradle.*")
            includeGroupByRegex("org.gradle.*")
            includeGroupByRegex("org.jetbrains.kotlin.*")
        }
    }

fun RepositoryHandler.spotless(): ArtifactRepository =
    gradlePluginPortal {
        content {
            includeGroupByRegex("com.diffplug.spotless.*")
        }
    }

fun RepositoryHandler.sonatypeSnapshots(
    groupRegexList: Set<String> = setOf(),
): MavenArtifactRepository =
    maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots") {
        content {
            groupRegexList.forEach(::includeGroupByRegex)
        }
    }

fun RepositoryHandler.androidxSnapshots(buildID: Int): MavenArtifactRepository =
    maven(url = "https://androidx.dev/snapshots/builds/$buildID/artifacts/repository")

fun RepositoryHandler.jetbrainsCompose(): MavenArtifactRepository =
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")

fun RepositoryHandler.ageSnapshots(): MavenArtifactRepository =
    sonatypeSnapshots(
        groupRegexList = setOf(
            "me.omico.age.*",
        ),
    )

fun RepositoryHandler.gradmSnapshots(): MavenArtifactRepository =
    sonatypeSnapshots(
        groupRegexList = setOf(
            "me.omico.gradm.*",
        ),
    )
