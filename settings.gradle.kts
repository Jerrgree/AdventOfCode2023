pluginManagement {
    plugins {
        kotlin("jvm") version "2.0.21"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "AdventOfCode2023"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}