plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.compose") version Version.composeMultiplatform
}

group = "com.dropbox.componentbox.discovery"

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
                implementation(Deps.Compose.uiGraphics)
                implementation(Deps.Compose.ui)

                implementation(project(":componentbox"))
                implementation(project(":util"))
                api(project(":samples:discovery:common"))
                api(project(":samples:discovery:theme"))
            }
        }
    }
}

android {
    compileSdkVersion(Version.androidCompileSdk)
}