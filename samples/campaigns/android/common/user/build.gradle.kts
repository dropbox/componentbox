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
    implementation(project(":samples:campaigns:android:common:scoping"))
    implementation("androidx.fragment:fragment-ktx:1.5.4")
    implementation(project(":samples:campaigns:android:common:binding"))

}

anvil {
    generateDaggerFactories.set(true)
}