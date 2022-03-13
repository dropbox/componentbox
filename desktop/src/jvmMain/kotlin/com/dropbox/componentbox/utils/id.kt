package com.dropbox.componentbox.utils

import java.util.UUID

fun id() = UUID.randomUUID().toString().split("-")[0]