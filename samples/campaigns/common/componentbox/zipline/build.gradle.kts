@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("app.cash.zipline")
}

group = "com.dropbox.componentbox.samples.campaigns"

kotlin {
    android()
    js {
        browser()
        binaries.executable()
    }
    ios()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.material)
                implementation(compose.ui)
                implementation(libs.zipline.zipline)
                implementation(project(":componentbox"))
                implementation(project(":zipline"))
            }
        }

        val hostMain by creating {
            dependsOn(commonMain)
            dependencies {
                api(libs.zipline.loader)
            }
        }

        val androidMain by getting {
            dependsOn(hostMain)
            dependencies {
                api(libs.androidx.viewmodel)
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


    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

}

zipline {
    mainFunction.set("com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline.main")
}