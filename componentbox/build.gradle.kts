@file:Suppress("UnstableApiUsage")

import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.vanniktech.maven.publish.base")
    id("org.jetbrains.dokka")
    id("co.touchlab.faktory.kmmbridge")
    `maven-publish`
    kotlin("native.cocoapods")
}

group = "com.dropbox.componentbox"

kotlin {
    android()
    jvm()
    js {
        browser()
        binaries.executable()
    }
    ios()

    cocoapods {
        summary = "ComponentBox"
        homepage = "https://github.com/dropbox/componentbox"
        ios.deploymentTarget = "13"
        version = "0.2.0-alpha01"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.kotlinx.serialization.core)
                api(libs.kotlinx.serialization.json)
            }
        }

        val jvmMain by getting {
        }

        val androidMain by getting {
            dependencies {
            }
        }

        val jsMain by getting {
            dependencies {
            }
        }

        val iosMain by getting
    }
}

android {

    compileSdk = 33

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets.configureEach {
        reportUndocumented.set(false)
        skipDeprecated.set(true)
        jdkVersion.set(8)
    }
}

addGithubPackagesRepository()
kmmbridge {
    githubReleaseArtifacts()
    githubReleaseVersions()
    versionPrefix.set("0.2.0-alpha0")
    spm()
}

mavenPublishing {
    publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.S01)
    signAllPublications()
}

