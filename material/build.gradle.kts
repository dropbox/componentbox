@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

group = "com.dropbox.componentbox"

kotlin {
    android()
    ios()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":componentbox"))
                api(project(":kit"))
                implementation(compose.runtime)
                implementation(compose.material)
            }
        }

        val iosMain by getting
    }
}

android {
    val minSdk = libs.versions.android.min.sdk.get()
    compileSdk = minSdk.toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}