package com.dropbox.componentbox.samples.counter.server

import app.cash.zipline.Zipline
import app.cash.zipline.ZiplineService

interface Test : ZiplineService {
    val value: String
}

data class RealTest(
    override val value: String
) : Test

@OptIn(ExperimentalJsExport::class)
@JsExport
fun launchZipline() {
    val zipline = Zipline.get()
    zipline.bind<Test>("triviaService", RealTest("component box"))
}