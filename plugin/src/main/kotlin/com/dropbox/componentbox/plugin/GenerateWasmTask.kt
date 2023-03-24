package com.dropbox.componentbox.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

open class GenerateWasmTask : DefaultTask() {
    @InputFile
    lateinit var inputFile: File

    @OutputFile
    lateinit var outputFile: File

    @TaskAction
    fun generateWasm() {
        val componentBox = project.extensions.getByType(ComponentBoxExtension::class.java).annotations
        // TODO()
    }
}