import com.vanniktech.maven.publish.JavadocJar.Dokka
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.compose") version Version.composeMultiplatform
    id("com.vanniktech.maven.publish.base")
    id("org.jetbrains.dokka")
    id("org.jetbrains.kotlin.native.cocoapods")
    id("com.rickclephas.kmp.nativecoroutines")
    id("com.chromaticnoise.multiplatform-swiftpackage") version "2.0.3"
    id("kotlin-android-extensions")
    id("app.cash.zipline")
}

multiplatformSwiftPackage {
    packageName("ComponentBox")
    swiftToolsVersion("5.3")
    targetPlatforms {
        iOS { v("14") }
    }
    outputDirectory(File(projectDir, "package"))
}

group = "com.dropbox.componentbox"

kotlin {
    android()
    jvm()
    js {
        browser()
        binaries.executable()
    }

    val xcf = XCFramework("componentbox")
    listOf(iosX64(), iosArm64(), iosSimulatorArm64()).forEach {
        it.binaries.framework {
            baseName = "componentbox"
            xcf.add(this)
        }
    }

    cocoapods {
        summary = "ComponentBox"
        homepage = "https://github.com/dropbox/componentbox"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {

                with(Deps.Kotlinx) {
                    api(serializationCore)
                    api(serializationJson)
                }

                with(Deps.Cash.Zipline) {
                    implementation(zipline)
                }

                with(Deps.Ktor){
                    implementation(clientCore)
                    implementation(clientSerialization)
                    implementation(clientContentNegotiation)
                    implementation(serializationKotlinxJson)
                    implementation(clientLogging)
                }
            }
        }

        val jvmMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.material)
                api(compose.ui)
                api(compose.foundation)
                implementation(Deps.Compose.coilCompose)
            }
        }

        val androidMain by getting {
            dependencies {

                with(Deps.AndroidX) {
                    api(appCompat)
                    api(coreKtx)
                }

                api(compose.runtime)
                api(compose.material)
                api(compose.ui)
                api(compose.foundation)
                implementation(Deps.Compose.coilCompose)

                with(Deps.Mavericks) {
                    implementation(mavericksCompose)
                }

                with(Deps.Cash) {
                    implementation(okhttp)
                }

                implementation(Deps.Airbnb.lottieCompose)

            }
        }

        val jsMain by getting {
            dependencies {
                api(compose.runtime)
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)

            dependencies {
                implementation(Deps.Ktor.clientIos)
            }

            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}

android {
    compileSdkVersion(Version.androidCompileSdk)

    lintOptions {
        disable += "ComposableModifierFactory"
        disable += "ModifierFactoryExtensionFunction"
        disable += "ModifierFactoryReturnType"
        disable += "ModifierFactoryUnreferencedReceiver"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.composeCompiler
        kotlinCompilerVersion = Version.baseKotlin
    }

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