package com.dropbox.componentbox.util

import java.util.UUID

fun id() = UUID.randomUUID().toString().split("-")[0]