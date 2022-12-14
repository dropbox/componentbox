@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

group = "com.dropbox.componentbox.samples.campaigns"

kotlin {
    android()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.material)
                implementation(compose.ui)
                implementation(project(":componentbox"))
                api(project(":samples:campaigns:common:componentbox:zipline"))
                implementation(project(":material"))
                implementation(libs.zipline.zipline)
            }
        }

        val androidMain by getting {
            dependencies {
                api(libs.androidx.viewmodel)
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


    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

}
