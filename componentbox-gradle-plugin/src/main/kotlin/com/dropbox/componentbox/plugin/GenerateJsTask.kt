package com.dropbox.componentbox.plugin

import com.dropbox.componentbox.Component
import org.gradle.api.DefaultTask
import org.gradle.api.file.Directory
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

open class GenerateJsTask : DefaultTask() {
    @OutputDirectory
    lateinit var outputDir: Directory

    @Input
    lateinit var root: Component

    @TaskAction
    fun generateJs() {
        val path = "js/${root::class.simpleName}.js"
        val outputFile = outputDir.file(path).asFile
        // Generate JS
        // Write JS to file
    }
}