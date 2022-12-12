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
include(":zipline")

include(":samples:campaigns:android:app")
include(":samples:campaigns:android:feature:account")
include(":samples:campaigns:common:componentbox:zipline")
include(":samples:campaigns:common:viewmodel")
