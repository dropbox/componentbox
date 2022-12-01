@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("android")
    id("com.android.application")
    id("com.squareup.anvil")
    id("kotlin-kapt")
}

group = "com.dropbox.componentbox.campaigns"

android {

    compileSdk = libs.versions.android.compile.sdk.get().toInt()

    defaultConfig {
        applicationId = "com.dropbox.componentbox.campaigns"
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
    implementation(project(":samples:campaigns:android:common:scoping"))
    implementation(project(":samples:campaigns:android:common:binding"))
    implementation(project(":samples:campaigns:android:common:user"))
    implementation(project(":samples:campaigns:android:feature:account"))

    implementation(libs.activity.compose)
    implementation(libs.compose.material)
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    implementation("androidx.fragment:fragment-ktx:1.5.4")
    implementation("androidx.appcompat:appcompat:1.5.1")

    implementation(libs.dagger.dagger)
    kapt(libs.dagger.compiler)
    implementation("com.airbnb.android:mavericks:3.0.1")
    implementation(project(":samples:campaigns:xplat:componentbox"))
}