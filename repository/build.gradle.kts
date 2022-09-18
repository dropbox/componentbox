@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
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
                api(libs.kotlinx.coroutines.core)
                implementation(project(":componentbox"))
            }
        }

        val hostMain by creating {
            dependsOn(commonMain)
            dependencies {
            }
        }

        val androidMain by getting {
            dependsOn(hostMain)
            dependencies {
                implementation(libs.store)
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
}