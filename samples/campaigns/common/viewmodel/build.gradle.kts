@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

group = "com.dropbox.componentbox.samples.campaigns"

kotlin {
    android()
    ios()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.material)
                implementation(compose.ui)
                implementation(project(":componentbox"))
                implementation(project(":kit"))
                implementation(project(":material"))
                implementation(project(":zipline"))
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
