package com.dropbox.componentbox.zipline

import app.cash.zipline.Zipline


private val zipline by lazy { Zipline.get() }

@OptIn(ExperimentalJsExport::class)
@JsExport
fun main() {
}