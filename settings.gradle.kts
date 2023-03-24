enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
    }

}
rootProject.name = "componentbox"

include(":componentbox")
include(":componentbox-gradle-plugin")

include(":samples:counter:android")
include(":samples:counter:common:zipline")
include(":samples:counter:server")
