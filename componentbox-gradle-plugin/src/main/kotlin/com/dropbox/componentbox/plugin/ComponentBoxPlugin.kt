package com.dropbox.componentbox.plugin

import app.cash.zipline.gradle.ZiplineCompileTask
import app.cash.zipline.gradle.ZiplinePlugin
import com.dropbox.componentbox.SerializableComponentBox
import com.dropbox.componentbox.Tree
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.impldep.org.objectweb.asm.Opcodes
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.objectweb.asm.AnnotationVisitor
import java.io.FileInputStream
import java.net.URL
import java.net.URLClassLoader

class ComponentBoxPlugin : Plugin<Project> {
    private val ziplinePlugin = ZiplinePlugin()

    override fun apply(target: Project) {
        target.pluginManager.apply("com.dropbox.componentbox.plugin")
        ziplinePlugin.apply(target)
        createZiplineExecutionTask(target)
        createComponentBoxJsonTask(target)
    }

    private fun createZiplineExecutionTask(target: Project) {
        val ziplineExecutionTask = target.tasks.register("componentBoxZipline") {
            it.group = "Component Box"
            it.description = "Execute all Zipline tasks"
        }

        target.tasks.withType(ZiplineCompileTask::class.java) { ziplineCompileTask ->
            ziplineExecutionTask.configure {
                it.dependsOn(ziplineCompileTask)
            }
        }
    }

    private fun createComponentBoxJsonTask(project: Project) {
        val compileTaskName = "compileKotlinMetadata"
        val compileTask = project.tasks.named(compileTaskName, KotlinCompile::class.java)

        val json = Json {
            prettyPrint = true
        }

        project.tasks.register("componentBoxJson") {

            it.dependsOn(compileTask)
            it.group = "Component Box"
            it.description =
                "Generate JSON from Component Box exports"

            it.doLast {

                val jvmMainOutputDir = project.buildDir.resolve("classes/kotlin/jvm/main")

                val files =
                    jvmMainOutputDir.walk().flatMap { file -> listOf(file, file.parentFile) }
                        .filter { file -> file.isFile && file.name.endsWith(".class") }
                        .toList()


                val urls = files.filter {
                    it.isFile && it.name.endsWith(".class")
                }.map {
                    it.toURI().toURL()
                }
                    .toTypedArray()

                val classpath = arrayOf(jvmMainOutputDir.toURI().toURL()) + urls
                val urlClassLoader = URLClassLoader(classpath, javaClass.classLoader)

                val annotatedClasses = mutableListOf<Pair<URL, String>>()


                urls.forEach { url ->
                    try {
                        val classReader = org.objectweb.asm.ClassReader(FileInputStream(url.path))
                        val myAnnotationChecker = MyAnnotationChecker()

                        classReader.accept(myAnnotationChecker, 0)

                        val className = classReader.className

                        if (myAnnotationChecker.hasAnnotation) {
                            annotatedClasses.add(Pair(url, className))
                        }
                    } catch (error: Throwable) {
                        println(error)
                    }
                }

                annotatedClasses.forEach { (url, className) ->
                    val name = className.replace("/", ".")

                    try {

                        val clazz = urlClassLoader.loadClass(name)
                        val method = clazz.methods.firstOrNull { method ->
                            method.isAnnotationPresent(SerializableComponentBox::class.java)
                        }

                        if (method != null) {
                            val instance = clazz.newInstance()
                            val result = method.invoke(instance) as? Tree.Static

                            if (result != null) {
                                val serializedResult = json.encodeToString<Tree.Static>(result)
                                val path = "/json/${className}/${method.name}.json"
                                val outputFile =
                                    project.file(project.projectDir.path + "/componentbox" + path)

                                if (!outputFile.parentFile.exists()) {
                                    outputFile.parentFile.mkdirs()
                                }

                                if (outputFile.exists()) {
                                    outputFile.writeText(serializedResult)
                                } else {
                                    outputFile.createNewFile()
                                    outputFile.writeText(serializedResult)
                                }

                            }
                        }
                    } catch (error: Throwable) {
                        println(error)
                    }
                }
            }
        }
    }
}


class MyAnnotationChecker : org.objectweb.asm.ClassVisitor(Opcodes.ASM9) {
    var hasAnnotation = false
    override fun visitAnnotation(
        descriptor: String?,
        visible: Boolean
    ): AnnotationVisitor {

        if (descriptor?.contains("Lcom/dropbox/componentbox/ComponentBoxExport;") == true) {
            hasAnnotation = true
        }

        return super.visitAnnotation(descriptor, visible) ?: FallbackAnnotationVisitor()
    }
}

class FallbackAnnotationVisitor : AnnotationVisitor(Opcodes.ASM9) {
    var hasAnnotation = false
}