plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose") version "1.3.1"
}

kotlin {
    jvm()
    ios()
    android()
    js {
        browser()
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                api(libs.kotlin.std.lib)
                api(libs.kotlinx.coroutines.core)
                implementation(project(":componentbox"))
                implementation(project(":model"))
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
}