import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost
import kotlinx.kover.tasks.KoverMergedHtmlReportTask
import kotlinx.kover.tasks.KoverMergedXmlReportTask

plugins {
    kotlin("jvm") version Version.baseKotlin
    id("org.jetbrains.dokka") version Version.baseKotlin
    id("org.jetbrains.kotlinx.kover") version "0.5.0"
}
@Suppress("JcenterRepositoryObsolete") buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath(Deps.Kotlin.gradlePlugin)
        classpath(Deps.Kotlin.serializationCore)
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
        classpath("com.vanniktech:gradle-maven-publish-plugin:0.18.0")
        classpath("org.jetbrains.kotlinx:kover:0.5.0")
        classpath("org.jetbrains.kotlinx:kotlinx-cli:0.3.4")
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

tasks.withType<KoverMergedHtmlReportTask>().configureEach {
    isEnabled = true
}
tasks.withType<KoverMergedXmlReportTask>().configureEach {
    isEnabled = true
}

tasks.register("printVersionName") {
    doLast {
        val VERSION_NAME: String by project
        println(VERSION_NAME)
    }
}

val included = listOf(
    "com.dropbox.componentbox.models.*"
)
val excluded = listOf(
    "com.dropbox.componentbox.discovery.*",
    "com.dropbox.componentbox.samples.*",
    "com.dropbox.componentbox.desktop.*"
)

tasks.koverMergedVerify {
    includes = included
    excludes = excluded

    rule {
        // TODO(mramotar) 80%
        name = "0% Coverage"
        bound {
            minValue = 0
        }
    }
}

tasks.koverMergedHtmlReport {
    isEnabled = true
    htmlReportDir.set(layout.buildDirectory.dir("generated/kover"))

    includes = included
    excludes = excluded
}
