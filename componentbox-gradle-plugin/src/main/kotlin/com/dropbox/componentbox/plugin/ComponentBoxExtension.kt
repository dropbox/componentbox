package com.dropbox.componentbox.plugin

import org.gradle.api.Project
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty

open class ComponentBoxExtension(project: Project) {
    val outputDir: DirectoryProperty = project.objects.directoryProperty()
    val configFile: RegularFileProperty = project.objects.fileProperty()
}