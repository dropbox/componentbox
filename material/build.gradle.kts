@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

group = "com.dropbox.componentbox"

kotlin {
    iosArm64()
    iosX64()
    iosSimulatorArm64()
    android()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":componentbox"))
                api(project(":ui"))
                implementation(compose.runtime)
                implementation(compose.material)
            }
        }

        val iosMain by creating {
            dependsOn(commonMain)
        }
        targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
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