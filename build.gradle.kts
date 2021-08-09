import me.omico.age.dsl.configureSpotlessWithCommonRules

buildscript {
    extra["group"] = "me.omico.age"
    extra["version"] = "1.0.0"
}

plugins {
    id("com.diffplug.spotless")
    id("com.github.ben-manes.versions")
}

allprojects {
    configureSpotlessWithCommonRules()
}
