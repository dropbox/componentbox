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
    id("org.jetbrains.kotlin.native.cocoapods")
}

group = "com.dropbox.componentbox"

kotlin {
    android()
    jvm()
    js {
        browser()
        binaries.executable()
    }

    val iosTarget: (String, org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget.() -> Unit) -> org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget =
        when {
            System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
            System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
            else -> ::iosX64
        }
    iosTarget("iOS") {}

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

                with(Deps.Zipline) {
                    implementation(ziplineSnapshot)
                    implementation(ziplineLoader)
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

                with(Deps.Ok) {
                    implementation(okhttp)
                }

                implementation("com.airbnb.android:lottie-compose:5.0.3")

            }
        }

        val jsMain by getting {
            dependencies {
                api(compose.runtime)
            }
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