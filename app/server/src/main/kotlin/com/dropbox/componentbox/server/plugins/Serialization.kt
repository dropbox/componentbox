package com.dropbox.componentbox.server.plugins

import ch.qos.logback.core.pattern.Converter
import com.dropbox.componentbox.foundation.ComponentBox
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.serialization.kotlinx.json.json
import io.ktor.serialization.kotlinx.serialization
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.ContentNegotiation

fun Application.configureSerialization() {

}
