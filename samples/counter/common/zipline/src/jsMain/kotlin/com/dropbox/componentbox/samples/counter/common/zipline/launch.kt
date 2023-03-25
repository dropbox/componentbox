package com.dropbox.componentbox.samples.counter.common.zipline

import app.cash.zipline.Zipline

private val zipline by lazy { Zipline.get() }

@OptIn(ExperimentalJsExport::class)
@JsExport
fun launch() {
}