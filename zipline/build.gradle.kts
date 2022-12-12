@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.vanniktech.maven.publish.base")
    id("app.cash.zipline")
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

        val iosMain by getting {
            dependsOn(hostMain)
        }
    }
}

android {
    compileSdk = libs.versions.android.compile.sdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.min.sdk.get().toInt()
    }
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}

mavenPublishing {
    publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.S01)
    signAllPublications()
}

tasks.withType(org.jetbrains.kotlin.gradle.targets.js.dukat.DukatTask::class) { enabled = false }