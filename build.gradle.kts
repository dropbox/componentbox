@file:Suppress("UnstableApiUsage")

import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    kotlin("jvm") version "1.7.10"
    id("org.jetbrains.dokka") version "1.7.10"
    id("org.jetbrains.kotlinx.kover") version "0.6.0"
}

buildscript {
    val kotlinVersion = "1.7.10"

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")

        classpath(kotlin("gradle-plugin", version = kotlinVersion))
        classpath(kotlin("serialization", version = kotlinVersion))

        classpath("com.google.dagger:hilt-android-gradle-plugin:2.42")
        classpath("com.vanniktech:gradle-maven-publish-plugin:0.18.0")
        classpath("org.jetbrains.kotlinx:kover:0.5.0")
        classpath("org.jetbrains.kotlinx:kotlinx-cli:0.3.4")
        classpath("com.rickclephas.kmp:kmp-nativecoroutines-gradle-plugin:0.12.6-new-mm")
        classpath("app.cash.zipline:zipline-gradle-plugin:0.9.1")
    }
}

apply(plugin = "com.vanniktech.maven.publish.base")

allprojects {
    version = project.property("VERSION_NAME") as String

    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }


    plugins.withId("com.vanniktech.maven.publish.base") {
        configure<MavenPublishBaseExtension> {
            publishToMavenCentral(SonatypeHost.S01)
            signAllPublications()
            pom {
                description.set("A Kotlin multiplatform library for building dynamic server-driven UI")
                name.set(project.name)
                url.set("https://github.com/dropbox/componentbox/")
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("repo")
                    }
                }
                scm {
                    url.set("https://github.com/dropbox/componentbox/")
                    connection.set("scm:git:git://github.com/dropbox/componentbox.git")
                    developerConnection.set("scm:git:ssh://git@github.com/dropbox/componentbox.git")
                }
                developers {
                    developer {
                        id.set("dropbox")
                        name.set("Dropbox, Inc.")
                    }
                }
            }
        }
    }
}

koverMerged {
    enable()

    xmlReport {
        onCheck.set(true)
        reportFile.set(layout.projectDirectory.file("kover/coverage.xml"))
    }

    htmlReport {
        onCheck.set(true)
        reportDir.set(layout.projectDirectory.dir("kover/html"))
    }

    verify {
        onCheck.set(true)
    }
}