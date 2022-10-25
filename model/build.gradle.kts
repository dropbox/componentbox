@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("app.cash.zipline")
}

group = "com.dropbox.componentbox"

kotlin {
    iosArm64()
    iosX64()
    iosSimulatorArm64()
    android()
    jvm()

    js {
        browser()
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":componentbox"))
                implementation(libs.okio.core)
                implementation(libs.zipline.zipline)
            }
        }

        val hostMain by creating {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.zipline.loader)
            }
        }

        val androidMain by getting {
            dependsOn(hostMain)
            dependencies {
                implementation(libs.okHttp.core)
                implementation(libs.androidx.viewmodel)
            }
        }

        val iosMain by creating {
            dependsOn(hostMain)
        }
        targets.withType<KotlinNativeTarget> {
            val main by compilations.getting
            main.defaultSourceSet.dependsOn(iosMain)
        }
    }
}

android {
    val minSdk = libs.versions.android.min.sdk.get()
    compileSdk = minSdk.toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}