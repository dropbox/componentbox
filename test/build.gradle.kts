//import com.dropbox.componentbox.plugin.componentBox

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.compose") version "1.3.1"
    id("com.dropbox.componentbox.plugin")
    kotlin("plugin.serialization")
}

repositories {
    mavenLocal()
    mavenCentral()
}


dependencies {
    compileOnly(gradleApi())

    implementation(libs.kotlin.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
    implementation(libs.kotlin.std.lib)
    implementation(project(":componentbox"))
    implementation(project(":model"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js:1.8.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.0")
    api(libs.kotlinx.serialization.core)
    api(libs.kotlinx.serialization.json)
    implementation(compose.runtime)
}

//
//componentBox {
//    val dir = project.layout.buildDirectory.dir("componentbox").get().asFile
//    if (!dir.exists()) {
//        dir.mkdir()
//    }
//    outputDir.set(dir)
//}
