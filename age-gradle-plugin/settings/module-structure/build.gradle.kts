plugins {
    `kotlin-dsl`
}

// See: https://github.com/gradle/gradle/issues/21151#issuecomment-1172894670
afterEvaluate {
    tasks.compileKotlin {
        kotlinOptions {
            apiVersion = "1.5"
            languageVersion = "1.5"
        }
    }
}
