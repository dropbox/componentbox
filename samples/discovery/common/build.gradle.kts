import org.jetbrains.kotlin.gradle.plugin.PLUGIN_CLASSPATH_CONFIGURATION_NAME

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.compose") version Version.composeMultiplatform
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
                implementation(Deps.Kotlinx.serializationCore)
                implementation(Deps.Kotlinx.serializationJson)
                implementation(Deps.Zipline.ziplineSnapshot)
                implementation(project(":componentbox"))
            }
        }

        val jsMain by getting {
            dependencies {
                with(Deps.Zipline) {
                    implementation(ziplineSnapshot)
                }
            }
        }

        val androidMain by getting {
            dependencies {
                with(Deps.Kotlinx) {
                    implementation(coroutinesAndroid)
                    implementation(serializationCore)
                }
                with(Deps.AndroidX) {
                    implementation(coreKtx)
                    implementation(appCompat)
                }
                with(Deps.Ok) {
                    implementation(okhttp)
                }
            }
        }

        val jvmMain by getting {
            dependencies {
                with(Deps.Ok) {
                    implementation(okhttp)
                }
            }
            dependencies {
                with(Deps.Zipline){
                    implementation(ziplineSnapshot)
                    implementation(ziplineLoader)
                }
            }
        }
    }
}

android {
    compileSdkVersion(Version.androidCompileSdk)
    compileSdk = Version.androidCompileSdk
}

rootProject.plugins.withType(org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin::class.java) {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().versions.webpackCli.version =
        "4.9.0"
}

val compilerConfiguration by configurations.creating {}


dependencies {
    add(PLUGIN_CLASSPATH_CONFIGURATION_NAME, Deps.Zipline.pluginSnapshot)
    compilerConfiguration(Deps.Zipline.ziplineGradlePlugin)
}

val compileZipline by tasks.creating(JavaExec::class) {
    dependsOn("compileProductionExecutableKotlinJs")
    classpath = compilerConfiguration
    main = "app.cash.zipline.gradle.ZiplineCompilerKt"
    args = listOf(
        "$buildDir/compileSync/main/productionExecutable/kotlin",
        "$buildDir/zipline",
    )
}

val jsBrowserProductionRun by tasks.getting {
    dependsOn(compileZipline)
}