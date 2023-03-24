package com.dropbox.componentbox.gradle

import com.dropbox.componentbox.ComponentBox
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.jetbrains.kotlin.gradle.dsl.KotlinJsProjectExtension
import java.io.File
import kotlin.reflect.KClass
import kotlin.reflect.full.hasAnnotation

open class GenerateJsTask : DefaultTask() {
    @InputFile
    lateinit var inputFile: File

    @OutputFile
    lateinit var outputFile: File

    @TaskAction
    fun generateJs() {
        val components = findComponents()

        val kotlinJs = project.extensions.getByName("kotlin") as KotlinJsProjectExtension
        val componentBox = kotlinJs.sourceSets.maybeCreate("componentBox")

        components.forEach { _ ->
            inputFile.let { file ->
                file.copyTo(outputFile)
                componentBox.kotlin.srcDir(outputFile)
            }
        }
    }

    private fun findComponents(): List<KClass<*>> {
        val classLoader = project.buildscript.classLoader
        val components = mutableListOf<KClass<*>>()

        inputFile.let { file ->
            if (file.extension == "kt") {
                val className = file.readText()
                        .substringAfter("object ")
                        .substringBefore(" {")
                        .replace("\n", "")
                        .replace(" ", "")

                val clazz = classLoader.loadClass(className).kotlin
                if (clazz.hasAnnotation<ComponentBox>()) {
                    components.add(clazz)
                }
            }
        }

        return components
    }
}