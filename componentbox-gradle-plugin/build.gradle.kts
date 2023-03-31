

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("java-gradle-plugin")
    id("maven-publish")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("app.cash.zipline")

}

dependencies {
    compileOnly(gradleApi())

    implementation(libs.kotlin.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
    implementation(project(":componentbox"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.0")
    api(libs.kotlinx.serialization.core)
    api(libs.kotlinx.serialization.json)
    implementation("app.cash.zipline:zipline:0.9.17")
    implementation("app.cash.zipline:zipline-gradle-plugin:0.9.17")
}

publishing {
    publications {
        create<MavenPublication>("pluginMavenPublication") {
            from(components["kotlin"])
            groupId = "com.dropbox.componentbox"
            artifactId = "componentbox-gradle-plugin"
            version = version.toString()
        }
    }
}

gradlePlugin {
    plugins {
        create("componentBoxZipline") {
            id = "com.dropbox.componentbox.plugin"
            implementationClass = "com.dropbox.componentbox.plugin.ComponentBoxPlugin"
        }
    }
}