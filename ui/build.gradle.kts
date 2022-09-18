@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose") version "1.2.0-alpha01-dev755"
}

group = "com.dropbox.componentbox"

kotlin {
    android()
    ios()
    js {
        browser()
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":componentbox"))
                implementation(project(":viewmodel"))
                implementation(compose.ui)
            }
        }

        val androidMain by getting {
            dependencies {
            }
        }
    }
}

android {
    val minSdk = libs.versions.android.min.sdk.get()
    compileSdk = minSdk.toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}