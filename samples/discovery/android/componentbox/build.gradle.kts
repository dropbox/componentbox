import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    kotlin("android")
    kotlin("kapt")
    id("com.android.library")
    id("org.jetbrains.compose") version Version.composeMultiplatform
}

group = "com.dropbox.componentbox.discovery"

android {
    compileSdk = Version.androidCompileSdk

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.composeCompiler
    }

    packagingOptions {
        resources {
            excludes += "META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":componentbox"))
    implementation(project(":samples:discovery:android:zipline"))

    with(Deps.Mavericks){
        implementation(mavericksCompose)
    }

    with(Deps.Compose) {
        implementation(accompanistNavigationAnimation)
        implementation(coilCompose)
        implementation(compiler)
        implementation(foundationLayout)
        implementation(material)
        implementation(navigation)
        implementation(ui)
        implementation(uiGraphics)
    }

    with(Deps.AndroidX) {
        implementation(appCompat)
    }
}

kapt {
    correctErrorTypes = true
}