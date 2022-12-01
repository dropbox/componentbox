@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
    id("com.squareup.anvil")
}

group = "com.dropbox.componentbox.campaigns"


android {
    compileSdk = libs.versions.android.compile.sdk.get().toInt()

    buildFeatures {
        compose = true
    }

    defaultConfig {
        minSdk = libs.versions.android.min.sdk.get().toInt()
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    implementation(libs.dagger.dagger)
    kapt(libs.dagger.compiler)
    implementation(project(":samples:campaigns:android:common:scoping"))
    implementation("androidx.fragment:fragment-ktx:1.5.4")
    implementation(project(":samples:campaigns:android:common:binding"))
    implementation(project(":samples:campaigns:android:common:user"))
    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    api("androidx.appcompat:appcompat:1.5.1")
    api(libs.kotlinx.coroutines.core)
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    anvil(project(":samples:campaigns:android:common:codegen"))
    implementation(project(":samples:campaigns:android:common:annotation"))
    implementation(project(":componentbox"))
    implementation(project(":material"))
    implementation(project(":model"))
    implementation("com.airbnb.android:mavericks-compose:3.0.1")
    api(project(":samples:campaigns:xplat:componentbox"))
}
