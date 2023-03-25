@file:Suppress("UNCHECKED_CAST")

package com.dropbox.componentbox.plugin

import com.dropbox.componentbox.Component
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetContainer
import java.io.File
import java.net.URL
import java.net.URLClassLoader
import java.nio.file.Files

class Scanner {
    operator fun invoke(project: Project): List<Class<Component>> {
        val components = mutableListOf<Class<Component>>()
        val container = project.extensions.getByName("kotlin") as KotlinSourceSetContainer

        val classNames = mutableListOf<String>()
        val urls = mutableListOf<URL>()

        container.sourceSets.filter { it.name == "main" }.map { sourceSet ->
            sourceSet.kotlin.sourceDirectories.forEach { dir ->
                Files.walk(dir.toPath()).filter {
                    Files.isRegularFile(it) && (it.toString().endsWith(".kt"))
                }.forEach { file ->
                    val url = file.toFile().toURI().toURL()
                    val className = file.toAbsolutePath().toString()
                        .substringAfter(dir.absolutePath.toString())
                        .removePrefix("/")
                        .removeSuffix(".kt")
                        .replace(File.separatorChar, '.')

                    urls.add(url)
                    classNames.add(className)
                }
            }
        }
        val loader = URLClassLoader(urls.toTypedArray())

        classNames.forEach {
            try {
                components.add(loader.loadClass(it) as Class<Component>)
            } catch (error: Throwable) {
                println(
                    """
                    Failed to load class: $it
                    Error: ${error.message}
                """.trimIndent()
                )
            }
        }
        return components
    }
}


