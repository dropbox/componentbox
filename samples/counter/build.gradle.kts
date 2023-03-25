plugins {
    kotlin("jvm")
}

dependencies {
    api(libs.kotlin.std.lib)
    api(libs.kotlinx.coroutines.core)
    implementation(project(":componentbox"))
}