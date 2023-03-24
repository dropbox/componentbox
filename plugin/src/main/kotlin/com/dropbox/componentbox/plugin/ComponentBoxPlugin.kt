package com.dropbox.componentbox.plugin

import com.dropbox.componentbox.Component
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File


import org.gradle.api.provider.Provider
import org.gradle.api.tasks.TaskProvider
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilerPluginSupportPlugin
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption
import org.jetbrains.kotlin.gradle.targets.js.ir.JsIrBinary
import org.jetbrains.kotlin.gradle.targets.js.ir.KotlinJsIrTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile


private const val GROUP = "componentBox"
private const val COMPONENT_BOX_JSON = "componentBoxJson"
private const val COMPONENT_BOX_JS = "componentBoxJs"
private const val COMPONENT_BOX_WASM = "componentBoxWasm"

open class ComponentBoxPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val extension = target.extensions.create(GROUP, ComponentBoxExtension::class.java)
        target.tasks.register(COMPONENT_BOX_JSON, GenerateJsonTask::class.java) { task ->
            task.group = GROUP
            task.description = "Generates JSON from Component Box"
            task.inputFile = extension.inputFile
            task.outputFile = extension.jsonOutputFile
        }

        target.tasks.register(COMPONENT_BOX_JS, GenerateJsTask::class.java) { task ->
            task.group = GROUP
            task.description = "Generates JS from Component Box"
            task.inputFile = extension.inputFile
            task.outputFile = extension.jsOutputFile
        }

        target.tasks.register(COMPONENT_BOX_WASM, GenerateWasmTask::class.java) { task ->
            task.group = GROUP
            task.description = "Generates WASM from Component Box"
            task.inputFile = extension.inputFile
            task.outputFile = extension.wasmOutputFile
        }
    }
}

open class ComponentBoxExtension {
    lateinit var inputFile: File
    lateinit var jsonOutputFile: File
    lateinit var jsOutputFile: File
    lateinit var wasmOutputFile: File
    lateinit var annotations: MutableList<Annotation>
}


private fun MutableList<Annotation>.components(): MutableList<Component> = flatMap { annotation ->
    annotation.annotationClass.java.declaredFields.map { field ->
        if (Component::class.java.isAssignableFrom(field.type)) {
            field.isAccessible = true
            val component = field.get(null) as Component
            component
        } else {
            null
        }
    }
}.filterNotNull().toMutableList()


open class GenerateJsonTask : DefaultTask() {
    @InputFile
    lateinit var inputFile: File

    @OutputFile
    lateinit var outputFile: File

    @TaskAction
    fun generateJson() {
        val componentBox = project.extensions.getByType(ComponentBoxExtension::class.java).annotations
        val json = Json.encodeToString<List<Component>>(componentBox.components())
        outputFile.writeText(json)
    }
}

open class GenerateJsTask : DefaultTask() {
    @InputFile
    lateinit var inputFile: File

    @OutputFile
    lateinit var outputFile: File

    @TaskAction
    fun generateJs() {
        val componentBox = project.extensions.getByType(ComponentBoxExtension::class.java).annotations
        // TODO()
    }
}

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