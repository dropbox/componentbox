package com.dropbox.componentbox.plugin

import com.dropbox.componentbox.Component
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

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

}