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
include(":material")
include(":kit")

include(":samples:campaigns:android:app")
include(":samples:campaigns:android:common:scoping")
include(":samples:campaigns:android:common:binding")
include(":samples:campaigns:android:common:annotation")
include(":samples:campaigns:android:common:codegen")
include(":samples:campaigns:android:common:user")
include(":samples:campaigns:android:feature:account")
include(":samples:campaigns:xplat:componentbox")
