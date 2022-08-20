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
                implementation(project(":componentbox"))
                implementation(project(":util"))

                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.preview)
                implementation(compose.material)

                with(Deps.Kotlin){
                    implementation(reflect)
                }

                with(Deps.AndroidX){
                    implementation(appCompat)
                }
                implementation(kotlin("reflect"))
            }
        }
    }
}

android {
    compileSdk = Version.androidCompileSdk

}