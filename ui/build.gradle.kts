import com.vanniktech.maven.publish.JavadocJar.Dokka
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.compose") version Version.composeMultiplatform
}

group = "com.dropbox.componentbox"

kotlin {
    android()
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":componentbox"))
                implementation(project(":util"))
                implementation(project(":material"))
                api(compose.runtime)
                api(compose.material)
                api(compose.ui)
                api(compose.foundation)
                implementation(Deps.Compose.coilCompose)

                with(Deps.AndroidX) {
                    api(appCompat)
                    api(coreKtx)
                }

                with(Deps.Kotlinx) {
                    api(serializationCore)
                    api(serializationJson)
                }

                with(Deps.Zipline) {
                    implementation(ziplineSnapshot)
                    implementation(ziplineLoader)
                }


            }
        }

        val jvmMain by getting

        val androidMain by getting {
            dependencies {
                with(Deps.Mavericks) {
                    implementation(mavericksCompose)
                }

                with(Deps.Ok) {
                    implementation(okhttp)
                }

                implementation("com.airbnb.android:lottie-compose:5.0.3")

            }
        }
    }
}

android {
    compileSdkVersion(Version.androidCompileSdk)
}