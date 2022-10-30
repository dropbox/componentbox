enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    plugins {
        val composeVersion = extra["compose.version"] as String
        id("org.jetbrains.compose").version(composeVersion)
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
include(":model")
include(":ui")

include(":samples:campaigns:android:app")
include(":samples:campaigns:android:common:scoping")
include(":samples:campaigns:android:common:binding")
include(":samples:campaigns:android:common:annotation")
include(":samples:campaigns:android:common:codegen")
include(":samples:campaigns:android:common:user")
include(":samples:campaigns:android:feature:account")
include(":samples:campaigns:xplat:componentbox")
