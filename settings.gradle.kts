enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        mavenLocal()
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
rootProject.name = "componentbox"

include(":componentbox")
include(":componentbox-gradle-plugin")
include(":zipline")
include(":model")
include(":test")

include(":samples:counter:android")
include(":samples:counter:server")