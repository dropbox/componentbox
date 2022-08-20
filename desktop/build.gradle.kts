import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version Version.composeMultiplatform
    kotlin("plugin.serialization")
}

group = "com.dropbox.componentbox"

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(project(":componentbox"))
                implementation(project(":util"))
                api(project(":samples:discovery:theme"))

                api(compose.desktop.currentOs)
                api(compose.preview)

                implementation(Deps.Kotlinx.serializationCore)
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:0.20.0")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")
                implementation("org.reduxkotlin:redux-kotlin-threadsafe-jvm:0.5.5")
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "Main"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "jvm"
            packageVersion = "1.0.0"
        }
    }
}

tasks.named<Copy>("jvmProcessResources") {
    duplicatesStrategy = DuplicatesStrategy.WARN
}

tasks.withType(JavaCompile::class.java).all {
    options.compilerArgs.add("-Xno-optimized-callable-references")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xno-optimized-callable-references")
    }
}