object Deps {
    object Airbnb {
        const val lottieCompose = "com.airbnb.android:lottie-compose:${Version.lottie}"
    }

    object Android {
        const val material = "com.google.android.material:material:${Version.material}"
    }

    object AndroidX {
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycleRuntimeKtx}"
        const val lifecycleViewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycleViewmodelKtx}"
        const val activityCompose = "androidx.activity:activity-compose:${Version.activityCompose}"
        const val appCompat = "androidx.appcompat:appcompat:1.4.1"
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
    }

    object Cash {
        object Zipline {
            const val zipline = "app.cash.zipline:zipline:${Version.zipline}"
            const val ziplineSnapshot = "app.cash.zipline:zipline:${Version.ziplineSnapshot}"
            const val ziplineLoader = "app.cash.zipline:zipline:${Version.zipline}"
            const val pluginSnapshot = "app.cash.zipline:zipline-kotlin-plugin:${Version.ziplineSnapshot}"
            const val plugin = "app.cash.zipline:zipline-kotlin-plugin:${Version.zipline}"
            const val ziplineGradlePlugin = "app.cash.zipline:zipline-gradle-plugin:${Version.zipline}"
        }

        const val okhttp = "com.squareup.okhttp3:okhttp:4.9.2"

        object SqlDelight {
            const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:${Version.sqlDelight}"
            const val driverAndroid = "com.squareup.sqldelight:android-driver:${Version.sqlDelight}"
            const val driverNative = "com.squareup.sqldelight:native-driver:${Version.sqlDelight}"
            const val driverSqlite = "com.squareup.sqldelight:sqlite-driver:${Version.sqlDelight}"
            const val runtime = "com.squareup.sqldelight:runtime:${Version.sqlDelight}"
        }
    }

    object Compose {
        const val compiler = "androidx.compose.compiler:compiler:${Version.composeCompiler}"
        const val ui = "androidx.compose.ui:ui:${Version.composeUi}"
        const val uiGraphics = "androidx.compose.ui:ui-graphics:${Version.composeUi}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Version.composeUi}"
        const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Version.composeUi}"
        const val material = "androidx.compose.material:material:${Version.composeMaterial}"
        const val navigation = "androidx.navigation:navigation-compose:${Version.navCompose}"

        const val coilCompose = "io.coil-kt:coil-compose:1.3.2"
        const val accompanistNavigationAnimation =
            "com.google.accompanist:accompanist-navigation-animation:${Version.accompanist}"
    }

    object Dropbox {
        const val store = "com.dropbox.mobile.store:store4:4.0.5"
    }

    object Kotlin {
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.baseKotlin}"
        const val serializationCore = "org.jetbrains.kotlin:kotlin-serialization:${Version.baseKotlin}"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Version.baseKotlin}"
    }

    object Kotlinx {
        const val serializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Version.kotlinxSerialization}"
        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.kotlinxSerialization}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.kotlinxCoroutines}"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlinxCoroutines}"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.kotlinxCoroutines}"
    }


    object Ktor {
        const val clientCore = "io.ktor:ktor-client-core:${Version.ktor}"
        const val clientSerialization = "io.ktor:ktor-client-serialization:${Version.ktor}"
        const val clientContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Version.ktor}"
        const val serializationKotlinxJson = "io.ktor:ktor-serialization-kotlinx-json:${Version.ktor}"
        const val clientLogging = "io.ktor:ktor-client-logging:${Version.ktor}"
        const val clientIos = "io.ktor:ktor-client-ios:${Version.ktor}"
    }

    object Mavericks {
        const val mavericksCompose = "com.airbnb.android:mavericks-compose:${Version.mavericksCompose}"
    }
}