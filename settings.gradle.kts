enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        mavenLocal()
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
    }
}
rootProject.name = "componentbox"

include(":componentbox")
include(":componentbox-gradle-plugin")
include(":test")
include(":zipline")

include(":samples:counter:android")
include(":samples:counter:server")