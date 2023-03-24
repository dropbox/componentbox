package com.dropbox.componentbox.gradle

import com.dropbox.componentbox.Component
import org.gradle.api.DefaultTask
import org.gradle.api.file.Directory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

open class GenerateWasmTask : DefaultTask() {
    @OutputDirectory
    lateinit var outputDir: Directory

    lateinit var roots: List<Component>

    @TaskAction
    fun generateJs() {
        roots.forEach { root ->
            val path = "wasm/${root::class.simpleName}.wasm"
            val outputFile = outputDir.file(path).asFile
            // Generate WASM
            // Write WASM to file
        }
    }
}