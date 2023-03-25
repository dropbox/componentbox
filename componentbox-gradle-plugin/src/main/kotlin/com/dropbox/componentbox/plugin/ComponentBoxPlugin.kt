package com.dropbox.componentbox.plugin


import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Input
import org.jetbrains.kotlin.gradle.dsl.KotlinJsProjectExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.targets
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

open class ComponentBoxPlugin : Plugin<Project> {
    private val scanner = Scanner()

    override fun apply(target: Project) = try {
        target.pluginManager.apply("com.dropbox.componentbox.plugin")
        val extension =
            target.extensions.create("componentBox", ComponentBoxExtension::class.java, target)

        val componentBoxDir = target.layout.buildDirectory.dir("componentbox").get().asFile
        if (!componentBoxDir.exists()) {
            componentBoxDir.mkdir()
        }
        extension.outputDir.set(componentBoxDir)

        val annotatedClasses = scanner(target)

        val jsonTask =
            target.tasks.register("componentBoxJson", AggregateTask::class.java) { task ->
                task.group = "componentBox"
                task.description = "Generates all JSON from Component Box"
                task.taskList = annotatedClasses.map { annotatedClass ->
                    val root = annotatedClass.newInstance()



                    target.tasks.register(
                        "componentBoxJson-${root.javaClass.simpleName}",
                        GenerateJsonTask::class.java
                    ) { subTask ->
                        subTask.group = "componentBox"
                        subTask.description =
                            "Generates JSON from Component Box for ${root.javaClass.simpleName}"
                        subTask.outputDir = extension.outputDir.get()
                        @Input
                        subTask.root = root
                    }
                }
            }

        val jsTask = target.tasks.register("componentBoxJs", AggregateTask::class.java) { task ->
            task.group = "componentBox"
            task.description = "Generates all JS from Component Box"
            task.taskList = annotatedClasses.map { annotatedClass ->
                val root = annotatedClass.newInstance()
                val subTask = target.tasks.register(
                    "componentBoxJs-${root.javaClass.simpleName}",
                    GenerateJsTask::class.java
                ) { subTask ->
                    subTask.group = "componentBox"
                    subTask.description =
                        "Generates JS from Component Box for ${root.javaClass.simpleName}"
                    subTask.outputDir = extension.outputDir.get()
                    @Input
                    subTask.root = root
                }

                val kotlinJs = target.extensions.getByName("kotlin") as KotlinJsProjectExtension
                val componentBox = kotlinJs.sourceSets.maybeCreate("componentBox")

                val compileJsTask =
                    target.tasks.register(
                        "compileComponentBoxJs-${root.javaClass.simpleName}",
                        Kotlin2JsCompile::class.java
                    ) { task ->
                        task.dependsOn(subTask)
                        task.source(componentBox.kotlin)
                    }

                val mainCompilation =
                    kotlinJs.targets.first { it.name == "js" }.compilations.named("main")
                mainCompilation.configure { it.compileKotlinTask.dependsOn(compileJsTask) }

                subTask
            }
        }

        val wasmTask =
            target.tasks.register("componentBoxWasm", AggregateTask::class.java) { task ->
                task.group = "componentBox"
                task.description = "Generates all WASM from Component Box"
                task.taskList = annotatedClasses.map { annotatedClass ->
                    val root = annotatedClass.newInstance()
                    target.tasks.register(
                        "componentBoxWasm-${root.javaClass.simpleName}",
                        GenerateWasmTask::class.java
                    ) { subTask ->
                        subTask.group = "componentBox"
                        subTask.description =
                            "Generates WASM from Component Box for ${root.javaClass.simpleName}"
                        subTask.outputDir = extension.outputDir.get()
                        @Input
                        subTask.root = root
                    }
                }
            }


    } catch (error: Throwable) {
        println(error)
        println(error.cause)
    }
}




