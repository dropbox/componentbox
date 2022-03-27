plugins {
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
    id("com.android.application")
    id("org.jetbrains.compose") version Version.composeMultiplatform
    id("dagger.hilt.android.plugin")
}

group = "com.dropbox.componentbox.android"

android {
    compileSdk = Version.androidCompileSdk

    defaultConfig {
        applicationId = "com.dropbox.componentbox.android"
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
            excludes += "META-INF/kotlinx-io.kotlin_module"
            excludes += "META-INF/atomicfu.kotlin_module"
            excludes += "META-INF/kotlinx-coroutines-io.kotlin_module"
            excludes += "META-INF/kotlinx-coroutines-core.kotlin_module"
        }
    }
}

dependencies {
    implementation(project(":componentbox"))
    implementation(project(":ui"))
    implementation(project(":material"))
    implementation(project(":util"))

    implementation(project(":samples:discovery:components"))
    implementation(project(":samples:discovery:theme"))


    implementation("com.google.dagger:hilt-android:2.40.3")
    kapt("com.google.dagger:hilt-android-compiler:2.40.3")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    annotationProcessor("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    implementation("io.ktor:ktor-client-core:2.0.0-beta-1")
    implementation("io.ktor:ktor-client-android:2.0.0-beta-1")
    implementation("io.ktor:ktor-client-okhttp:2.0.0-beta-1")
    implementation("io.ktor:ktor-utils-jvm:2.0.0-beta-1")
    implementation("io.ktor:ktor-client-logging-jvm:2.0.0-beta-1")
    implementation("io.ktor:ktor-client-content-negotiation:2.0.0-beta-1")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.0.0-beta-1")
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:1.6.10")
    implementation("io.ktor:ktor-client-cio:2.0.0-beta-1")
    implementation("io.ktor:ktor-client-websockets:2.0.0-beta-1")
    implementation("com.google.accompanist:accompanist-swiperefresh:0.24.5-alpha")


    with(Deps.Mavericks) {
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

    implementation(Deps.Kotlinx.serializationCore)
    implementation(Deps.Kotlinx.serializationJson)

    with(Deps.Zipline) {
        implementation(ziplineSnapshot)
        implementation(ziplineLoader)
    }

    add(org.jetbrains.kotlin.gradle.plugin.PLUGIN_CLASSPATH_CONFIGURATION_NAME, Deps.Zipline.pluginSnapshot)
}

kapt {
    correctErrorTypes = true
}