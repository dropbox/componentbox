import com.vanniktech.maven.publish.JavadocJar.Dokka
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import org.jetbrains.dokka.gradle.DokkaTask

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

                with(Deps.Zipline) {
                    implementation(ziplineSnapshot)
                    implementation(ziplineLoader)
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
                api(compose.foundation)
                implementation(Deps.Compose.coilCompose)

                with(Deps.Mavericks) {
                    implementation(mavericksCompose)
                }

                with(Deps.Ok) {
                    implementation(okhttp)
                }
            }
        }
    }
}

android {
    compileSdkVersion(Version.androidCompileSdk)
}

dependencies {
    add(org.jetbrains.kotlin.gradle.plugin.PLUGIN_CLASSPATH_CONFIGURATION_NAME, Deps.Zipline.pluginSnapshot)
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets.configureEach {
        reportUndocumented.set(false)
        skipDeprecated.set(true)
        jdkVersion.set(8)
    }
}

configure<MavenPublishBaseExtension> {
    configure(
        KotlinMultiplatform(javadocJar = Dokka("dokkaGfm"))
    )
}