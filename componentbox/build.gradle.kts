@file:Suppress("UnstableApiUsage")

import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("multiplatform") version "1.8.20-Beta"
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.dokka")
}

group = "com.dropbox.componentbox"

kotlin {
    android()
    jvm()
    js {
        nodejs()
        binaries.executable()
    }
    ios()

    wasm {
        binaries.executable()
        nodejs()
        compilations.all {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
                languageVersion = "1.7"
            }
        }
    }


    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.kotlinx.serialization.core)
                api(libs.kotlinx.serialization.json)
                api(libs.kotlin.std.lib)
                api(libs.kotlinx.coroutines.core)
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

        val wasmMain by getting
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