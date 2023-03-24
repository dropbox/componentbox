package com.dropbox.componentbox.gradle

import java.io.File

open class ComponentBoxExtension {
    lateinit var inputFile: File
    lateinit var jsonOutputFile: File
    lateinit var jsOutputFile: File
    lateinit var wasmOutputFile: File
    lateinit var annotations: MutableList<Annotation>
}