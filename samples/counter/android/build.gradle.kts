plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion = "android-31"

    defaultConfig {
        minSdk = libs.versions.android.min.sdk.get().toInt()
        setTargetSdkVersion(libs.versions.android.target.sdk.get())
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.compose.ui:ui:1.5.0-alpha01")
    implementation("androidx.compose.foundation:foundation:1.5.0-alpha01")
    implementation("androidx.compose.material:material:1.5.0-alpha01")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.3")

    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.3")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.caoccao.javet:javet:2.1.0")
    implementation("com.caoccao.javet:javet-macos:2.1.0")
    implementation("com.caoccao.javet:javet-android:2.1.0")

    implementation("io.ktor:ktor-client-core:2.2.4")
    implementation("io.ktor:ktor-client-json:2.2.4")
    implementation("io.ktor:ktor-client-serialization:2.2.4")

    implementation("androidx.activity:activity-compose:1.7.0")


    api(libs.kotlin.std.lib)
    api(libs.kotlinx.coroutines.core)
    implementation(project(":componentbox"))
    implementation(project(":samples:counter:common:zipline"))
}