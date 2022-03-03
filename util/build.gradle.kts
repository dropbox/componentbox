plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.compose") version Version.composeMultiplatform
    id("com.vanniktech.maven.publish.base")
    id("org.jetbrains.dokka")
}

group = "com.dropbox.componentbox"

kotlin {
    android()
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.preview)
                implementation(compose.material)

                implementation(project(":componentbox"))
            }
        }
    }
}

android {
    compileSdkVersion(Version.androidCompileSdk)
}