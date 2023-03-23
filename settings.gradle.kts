enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    plugins {
        val kmmBridgeVersion = extra["kmmBridgeVersion"] as String
        id("co.touchlab.faktory.kmmbridge").version(kmmBridgeVersion)
    }

    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }

}
rootProject.name = "componentbox"

include(":componentbox")
