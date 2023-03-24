package com.dropbox.componentbox.plugin


import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinJsProjectExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.targets
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

open class ComponentBoxPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val extension = target.extensions.create("componentBox", ComponentBoxExtension::class.java)
        target.tasks.register("componentBoxJson", GenerateJsonTask::class.java) { task ->
            task.group = "componentBox"
            task.description = "Generates JSON from Component Box"
            task.inputFile = extension.inputFile
            task.outputFile = extension.jsonOutputFile
        }

        val kotlinJs = target.extensions.getByName("kotlin") as KotlinJsProjectExtension
        val componentBox = kotlinJs.sourceSets.maybeCreate("componentBox")

        val generateJsTask = target.tasks.register("componentBoxJs", GenerateJsTask::class.java) { task ->
            task.group = "componentBox"
            task.description = "Generates JS from Component Box"
            task.inputFile = extension.inputFile
            task.outputFile = extension.jsOutputFile
        }

        val compileJsTask = target.tasks.register("compileComponentBoxJs", Kotlin2JsCompile::class.java) { task ->
            task.dependsOn(generateJsTask)
            task.source(componentBox.kotlin)
        }

        val mainCompilation = kotlinJs.targets.first { it.name == "js" }.compilations.named("main")
        mainCompilation.configure { it.compileKotlinTask.dependsOn(compileJsTask) }

        target.tasks.register("componentBoxWasm", GenerateWasmTask::class.java) { task ->
            task.group = "componentBox"
            task.description = "Generates WASM from Component Box"
            task.inputFile = extension.inputFile
            task.outputFile = extension.wasmOutputFile
        }
    }
}


