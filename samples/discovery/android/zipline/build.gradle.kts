import org.jetbrains.kotlin.gradle.plugin.PLUGIN_CLASSPATH_CONFIGURATION_NAME

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.compose") version Version.composeMultiplatform
    id("app.cash.zipline")
}

group = "com.dropbox.componentbox.discovery"

kotlin {
    android()
    js {
        browser()
        binaries.executable()
    }
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":componentbox"))

                implementation(compose.runtime)
                implementation(Deps.Cash.Zipline.zipline)

                with(Deps.Kotlinx){
                    implementation(serializationCore)
                    implementation(serializationJson)
                    implementation(coroutinesCore)
                }
            }
        }

        val jvmMain by getting {
            dependencies {
                with(Deps.Cash) {
                    implementation(okhttp)
                }
            }
        }

        val androidMain by getting {
            dependencies {
                dependsOn(jvmMain)
                with(Deps.Kotlinx) {
                    implementation(coroutinesAndroid)
                    implementation(serializationCore)
                }
                with(Deps.AndroidX) {
                    implementation(coreKtx)
                    implementation(appCompat)
                }
            }
        }
    }
}

android {
    compileSdkVersion(Version.androidCompileSdk)
}

rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
    val nodeJsRootExtension = rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>()
    nodeJsRootExtension.versions.webpackCli.version = "4.9.0"
    nodeJsRootExtension.nodeVersion = "16.0.0"
}