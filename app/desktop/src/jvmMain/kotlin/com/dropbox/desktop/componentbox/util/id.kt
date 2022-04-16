package com.dropbox.desktop.componentbox.util

import java.util.UUID

fun id() = UUID.randomUUID().toString().split("-")[0]