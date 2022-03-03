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
    js {
        browser()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)

                with(Deps.AndroidX) {
                    api(appCompat)
                    api(coreKtx)
                }

                with(Deps.Kotlinx) {
                    api(serializationCore)
                    api(serializationJson)
                }
            }
        }

        val jvmMain by getting {
            dependencies {
                api(compose.material)
                api(compose.ui)
            }
        }

        val androidMain by getting {
            dependencies {
                api(compose.material)
                api(compose.ui)
            }
        }
    }
}

android {
    compileSdkVersion(Version.androidCompileSdk)
}