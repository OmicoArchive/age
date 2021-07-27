@file:Suppress("unused")

package me.omico.age

import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.kotlin.dsl.maven

fun RepositoryHandler.sonatypeSnapshots(): MavenArtifactRepository =
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
