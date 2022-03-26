import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version Version.composeMultiplatform
    kotlin("plugin.serialization")
}

group = "com.dropbox.componentbox.discovery"

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":componentbox"))
                implementation(project(":util"))
                api(project(":samples:discovery:theme"))
                implementation(project(":samples:discovery:components"))
            }
        }

        val jvmMain by getting {
            dependencies {
                api(project(":app:desktop"))
                api(compose.desktop.currentOs)
                api(compose.preview)
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

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xno-optimized-callable-references")
    }
}

tasks.withType(JavaCompile::class.java).all {
    options.compilerArgs.add("-Xno-optimized-callable-references")
}