plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
    id("app.cash.zipline")

}

apply(plugin = "kotlinx-atomicfu")


kotlin {
    jvm()

    iosArm64()
    iosX64()

    android()

    js {
        browser()
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("app.cash.zipline:zipline:0.9.17")
                implementation(project(":componentbox"))
                implementation("io.ktor:ktor-client-core:2.2.4")
                implementation("io.ktor:ktor-client-json:2.2.4")
                implementation("io.ktor:ktor-client-serialization:2.2.4")
            }
        }

        val hostMain by creating {
            dependsOn(commonMain)
            dependencies {
                implementation("app.cash.zipline:zipline-loader:0.9.17")
                api(libs.okio.core)
            }
        }

        val androidMain by getting {
            dependsOn(hostMain)
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:2.2.4")

            }
        }
        val iosMain by creating {
            dependsOn(hostMain)
        }
    }
}

android {

    compileSdk = libs.versions.android.compile.sdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.min.sdk.get().toInt()
    }

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}


zipline {
    mainFunction.set("com.dropbox.componentbox.samples.counter.common.zipline.launch")
}