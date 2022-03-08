import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    kotlin("android")
    kotlin("kapt")
    id("com.android.application")
    id("org.jetbrains.compose") version Version.composeMultiplatform
    kotlin("plugin.serialization")
    id("dagger.hilt.android.plugin")
}

group = "com.dropbox.componentbox.discovery"

android {
    compileSdk = Version.androidCompileSdk

    defaultConfig {
        applicationId = "com.dropbox.componentbox.discovery"
        minSdkVersion(Version.androidMinSdk)
        targetSdkVersion(Version.androidTargetSdk)
    }

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
    implementation(project(":util"))
    implementation(project(":samples:discovery:common"))
    implementation(project(":samples:discovery:components"))
    implementation(project(":samples:discovery:theme"))
    implementation(project(":samples:discovery:android:componentbox"))
    implementation(project(":samples:discovery:android:zipline"))

    implementation("com.google.dagger:hilt-android:2.40.3")
    kapt("com.google.dagger:hilt-android-compiler:2.40.3")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    annotationProcessor("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

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

    with(Deps.Zipline) {
        implementation(ziplineSnapshot)
        implementation(ziplineLoader)
    }

    add(org.jetbrains.kotlin.gradle.plugin.PLUGIN_CLASSPATH_CONFIGURATION_NAME, Deps.Zipline.pluginSnapshot)
}

kapt {
    correctErrorTypes = true
}