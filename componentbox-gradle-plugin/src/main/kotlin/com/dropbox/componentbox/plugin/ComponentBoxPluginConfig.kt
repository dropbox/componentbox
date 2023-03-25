package com.dropbox.componentbox.plugin

import org.gradle.api.Project

fun Project.componentBox(configuration: ComponentBoxExtension.() -> Unit) {
    this.extensions.configure("componentBox", configuration)
}