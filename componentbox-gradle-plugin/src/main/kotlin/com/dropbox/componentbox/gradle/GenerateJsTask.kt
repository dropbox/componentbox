package com.dropbox.componentbox.gradle

import com.dropbox.componentbox.Component
import org.gradle.api.DefaultTask
import org.gradle.api.file.Directory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

open class GenerateJsTask : DefaultTask() {
    @OutputDirectory
    lateinit var outputDir: Directory

    lateinit var roots: List<Component>

    @TaskAction
    fun generateJs() {
        roots.forEach { root ->
            val path = "js/${root::class.simpleName}.js"
            val outputFile = outputDir.file(path).asFile
            // Generate JS
            // Write JS to file
        }
    }
}