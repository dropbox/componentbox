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
}

dependencies {
    implementation(libs.dagger.dagger)
    kapt(libs.dagger.compiler)
}