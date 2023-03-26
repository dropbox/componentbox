@file:Suppress("UnstableApiUsage")

import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("multiplatform") version "1.8.10"
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.dokka")
    id("maven-publish")
    id("org.jetbrains.compose") version "1.3.1"
}


kotlin {
    android()
    jvm()
    js {
        browser()
        binaries.executable()
    }
    ios()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.kotlinx.serialization.core)
                api(libs.kotlinx.serialization.json)
                api(libs.kotlin.std.lib)
                api(libs.kotlinx.coroutines.core)
                implementation(compose.runtime)
            }
        }

        val jvmMain by getting {
        }

        val androidMain by getting {
            dependencies {
            }
        }

        val jsMain by getting {
            dependencies {
            }
        }

        val iosMain by getting
    }
}

android {

    compileSdk = libs.versions.android.compile.sdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.min.sdk.get().toInt()
    }

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets.configureEach {
        reportUndocumented.set(false)
        skipDeprecated.set(true)
        jdkVersion.set(8)
    }
}

publishing {
    publications {
        create<MavenPublication>("componentBoxMavenPublication") {
            from(components["kotlin"])
            groupId = group.toString()
            artifactId = "componentbox"
            version = version.toString()
        }
    }
}
