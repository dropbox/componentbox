@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("app.cash.zipline")
    kotlin("plugin.serialization")
}

group = "com.dropbox.componentbox.samples.campaigns"

kotlin {
    android()
    js {
        browser()
        binaries.executable()
    }
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.serialization.core)
                api(libs.zipline.zipline)
                implementation(project(":componentbox"))
            }
        }

        val hostMain by creating {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.zipline.loader)
                api(libs.okio.core)
            }
        }

        val androidMain by getting {
            dependsOn(hostMain)
            dependencies {
                api(libs.androidx.viewmodel)
                implementation(libs.okHttp.core)
            }
        }
    }
}


android {
    compileSdk = libs.versions.android.compile.sdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.min.sdk.get().toInt()
    }
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    namespace = "com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline"

}

zipline {
    mainFunction.set("com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline.main")
}