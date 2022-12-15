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