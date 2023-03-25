import com.dropbox.componentbox.plugin.componentBox

plugins {
    id("org.jetbrains.kotlin.jvm")
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
    implementation(project(":componentbox-gradle-plugin"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js:1.8.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.0")
    api(libs.kotlinx.serialization.core)
    api(libs.kotlinx.serialization.json)
}


componentBox {
    outputDir.apply { project.layout.buildDirectory.dir("output/componentbox") }
}
