plugins {
    `java-gradle-plugin`
    `maven-publish`
    id("org.gradle.kotlin.kotlin-dsl")
}

kotlin {
    sourceSets["main"].kotlin.srcDir("../buildSrc/src/main/kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

gradlePlugin {
    plugins {
        register("androidGradleExtensions") {
            id = "me.omico.age"
            implementationClass = "me.omico.age.AndroidGradleExtensionsPlugin"
        }
    }
}

dependencies {
    compileOnly("com.android.tools.build:gradle:7.1.0-alpha06")
    compileOnly("com.diffplug.spotless:com.diffplug.spotless.gradle.plugin:5.14.2")
    compileOnly(gradleApi())
    compileOnly(gradleKotlinDsl())
    compileOnly(kotlin("gradle-plugin", "1.5.21"))
    compileOnly(kotlin("reflect", "1.5.21"))
    compileOnly(kotlin("stdlib", "1.5.21"))
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from("../buildSrc/src/main/kotlin")
}

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("age") {
            groupId = rootProject.extra["group"] as String
            artifactId = "me.omico.age.gradle.plugin"
            version = rootProject.extra["version"] as String
            from(components["kotlin"])
            artifact(sourcesJar)
        }
    }
}
