plugins {
    id("org.jetbrains.kotlin.jvm")
    id("java-gradle-plugin")
    id("maven-publish")
    id("org.jetbrains.kotlin.plugin.serialization")
}

dependencies {
    compileOnly(gradleApi())

    implementation(libs.kotlin.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
    implementation(libs.kotlin.std.lib)
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation(project(":componentbox"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js:1.8.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.0")
    api(libs.kotlinx.serialization.core)
    api(libs.kotlinx.serialization.json)

}
gradlePlugin {
    plugins {
        create("componentBox") {
            id = "com.dropbox.componentbox.plugin"
            implementationClass = "com.dropbox.componentbox.plugin.ComponentBoxPlugin"
        }
    }
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