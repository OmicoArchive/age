import me.omico.age.dsl.configureSpotlessWithCommonRules

plugins {
    id("com.diffplug.spotless")
    id("com.github.ben-manes.versions")
}

allprojects {
    group = "me.omico.age"
    version = "1.0.0"
    configureSpotlessWithCommonRules()
}
