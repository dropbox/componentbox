package com.dropbox.componentbox.gradle

import org.gradle.api.file.Directory
import org.gradle.api.file.RegularFileProperty

open class ComponentBoxExtension {
    lateinit var configFile: RegularFileProperty
    lateinit var outputDir: Directory
}