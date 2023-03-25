package com.dropbox.componentbox.plugin

import com.dropbox.componentbox.Component
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.gradle.api.DefaultTask
import org.gradle.api.file.Directory
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

open class GenerateJsonTask : DefaultTask() {
    @OutputDirectory
    lateinit var outputDir: Directory

    @Input
    lateinit var root: Component

    @TaskAction
    fun generateJson() {
        val json = Json.encodeToString(root)
        val path = "json/${root::class.simpleName}.json"
        val outputFile = outputDir.file(path).asFile
        outputFile.writeText(json)
    }
}