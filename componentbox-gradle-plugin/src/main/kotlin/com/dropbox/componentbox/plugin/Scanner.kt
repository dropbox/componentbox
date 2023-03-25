package com.dropbox.componentbox.plugin

import com.dropbox.componentbox.Component
import com.dropbox.componentbox.ComponentBox
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension
import java.net.URLClassLoader
import java.nio.file.Files

class Scanner {
    operator fun invoke(project: Project): List<Class<out Component>> {
        val annotatedClasses = mutableListOf<Class<out Component>>()

        val mainSourceSet = project.kotlinExtension.sourceSets.getByName("main")
        mainSourceSet.kotlin.setSrcDirs(setOf("src/main/kotlin"))
        val classPath = mainSourceSet.kotlin.srcDirs.map { it.toURI().toURL() }.toTypedArray()
        val classLoader = URLClassLoader(classPath, project.javaClass.classLoader)

        for (file in mainSourceSet.kotlin.srcDirs) {
            Files.walk(file.toPath())
                .filter { it.toString().endsWith(".class") }
                .map { it.toFile() }
                .forEach {
                    val className =
                        it.absolutePath.substringAfter(file.absolutePath).removeSuffix(".class")
                            .replace("/", ".")
                    val clazz = classLoader.loadClass(className)

                    if (clazz.isAnnotationPresent(ComponentBox::class.java) && Component::class.java.isAssignableFrom(
                            clazz
                        )
                    ) {
                        annotatedClasses.add(clazz as Class<out Component>)
                    }
                }
        }

        return annotatedClasses
    }
}


