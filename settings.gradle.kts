enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    plugins {
        val composeVersion = extra["composeVersion"] as String
        id("org.jetbrains.compose").version(composeVersion)

        val kmmBridgeVersion = extra["kmmBridgeVersion"] as String
        id("co.touchlab.faktory.kmmbridge").version(kmmBridgeVersion)
    }

    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

}
rootProject.name = "componentbox"

include(":componentbox")
include(":kit")
include(":material")
include(":model")
