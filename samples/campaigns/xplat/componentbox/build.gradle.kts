import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
    id("app.cash.zipline")
}

kotlin {
    iosArm64()
    iosX64()
    iosSimulatorArm64()

    android()

    js {
        browser()
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.zipline.zipline)
                api(project(":componentbox"))
                implementation(project(":model"))
            }
        }
        val hostMain by creating {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.zipline.loader)
                api(libs.okio.core)
                api(project(":material"))
            }
        }

        val androidMain by getting {
            dependsOn(hostMain)
            dependencies {
                implementation(libs.okHttp.core)
                implementation("com.airbnb.android:mavericks-compose:3.0.1")
            }
        }
        val iosMain by creating {
            dependsOn(hostMain)
        }
        targets.withType<KotlinNativeTarget> {
            val main by compilations.getting
            main.defaultSourceSet.dependsOn(iosMain)
        }
    }
}

android {
    compileSdk = 33
    namespace = "com.dropbox.componentbox.campaigns.xplat.zipline"
}

zipline {
    mainFunction.set("com.dropbox.componentbox.campaigns.xplat.componentbox.main")
}