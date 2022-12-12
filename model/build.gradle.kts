@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("com.vanniktech.maven.publish.base")
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
                implementation(compose.runtime)
                implementation(compose.material)
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
    val minSdk = libs.versions.android.min.sdk.get()
    compileSdk = minSdk.toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}

mavenPublishing {
    publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.S01)
    signAllPublications()
}