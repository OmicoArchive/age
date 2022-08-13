plugins {
    `kotlin-dsl`
    id("age.build-logic.maven-publish")
}

dependencies {
    implementation(projects.ageDsl)
}
