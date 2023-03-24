package com.dropbox.componentbox.gradle


import com.dropbox.componentbox.Component
import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.ComponentBoxConfig
import com.dropbox.componentbox.Tree
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinJsProjectExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.targets
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile
import java.io.DataInputStream
import java.io.File
import java.io.FileInputStream
import java.net.URLClassLoader
import kotlin.reflect.full.findAnnotation


private fun findRoot(file: File, classLoader: ClassLoader): Component? {
    if (file.extension != "kt") {
        return null
    }

    val name = file.readText()
            .substringAfter("object ")
            .substringBefore(" {")
            .replace("\n", "")
            .replace(" ", "")

    val cls = classLoader.loadClass(name).kotlin
    val annotation = cls.findAnnotation<ComponentBox>() ?: return null

    if (!annotation.tree.isInstance(cls.objectInstance)) {
        return null
    }

    val tree = cls.objectInstance as Tree
    return tree.root
}

public open class ComponentBoxPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("com.dropbox.componentbox.plugin")

        val extension = target.extensions.create("componentBox", ComponentBoxExtension::class.java)

        val configFile = extension.configFile.get().asFile
        val configs = Json.decodeFromString<List<ComponentBoxConfig>>(configFile.readText())

        val roots = mutableListOf<Component>()

        configs.forEach { config ->
            val file = File(config.file)
            val inputStream = FileInputStream(file)
            val input = DataInputStream(inputStream)
            val bytes = ByteArray(file.length().toInt())
            input.readFully(bytes)

            val classLoader = URLClassLoader(arrayOf(file.toURI().toURL()), javaClass.classLoader)
            val tree = classLoader.loadClass(config.tree)
            val root = tree.newInstance() as Component
            roots.add(root)
        }

        target.tasks.register("componentBoxJson", GenerateJsonTask::class.java) { task ->
            task.group = "componentBox"
            task.description = "Generates JSON from Component Box"
            task.outputDir = extension.outputDir
            task.roots = roots
        }

        val kotlinJs = target.extensions.getByName("kotlin") as KotlinJsProjectExtension
        val componentBox = kotlinJs.sourceSets.maybeCreate("componentBox")

        val generateJsTask = target.tasks.register("componentBoxJs", GenerateJsTask::class.java) { task ->
            task.group = "componentBox"
            task.description = "Generates JS from Component Box"
            task.outputDir = extension.outputDir
            task.roots = roots
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
            task.outputDir = extension.outputDir
            task.roots = roots
        }
    }
}


