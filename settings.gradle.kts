@Suppress("JcenterRepositoryObsolete")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

}
rootProject.name = "componentbox"

include(":componentbox")
include(":desktop")
include(":util")
include(":samples:discovery:android")
include(":samples:discovery:common")
include(":samples:discovery:components")
include(":samples:discovery:desktop")
include(":samples:discovery:theme")
include(":samples:discovery:zipline")
