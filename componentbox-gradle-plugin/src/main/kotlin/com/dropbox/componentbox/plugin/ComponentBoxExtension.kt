package com.dropbox.componentbox.plugin

import org.gradle.api.Project
import org.gradle.api.file.DirectoryProperty

open class ComponentBoxExtension(project: Project) {
    val outputDir: DirectoryProperty = project.objects.directoryProperty()
}