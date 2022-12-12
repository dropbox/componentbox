@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("android")
    id("com.android.library")
}

group = "com.dropbox.componentbox.samples.campaigns"

android {

    compileSdk = libs.versions.android.compile.sdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.min.sdk.get().toInt()
        targetSdkVersion(libs.versions.android.target.sdk.get())
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    packagingOptions {
        resources {
            excludes += "META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.compose.material)
    implementation(libs.compose.ui)
    implementation(libs.androidx.viewmodel)
    implementation(libs.androidx.viewmodel.compose)
    implementation(libs.coil.compose)
    implementation(project(":componentbox"))
    implementation(project(":kit"))
    implementation(project(":material"))
    implementation(project(":zipline"))
    implementation(project(":samples:campaigns:common:viewmodel"))
}