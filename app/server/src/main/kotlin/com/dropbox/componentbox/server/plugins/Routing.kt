package com.dropbox.componentbox.server.plugins

import com.dropbox.componentbox.foundation.ComponentBox
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.http.content.resources
import io.ktor.server.http.content.static
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import kotlinx.coroutines.flow.MutableStateFlow

fun Application.configureRouting() {
    val root: MutableStateFlow<ComponentBox.Screen?> = MutableStateFlow(null)

    routing {
        get("/") {

            if (root.value != null) {
                call.respond(root.value!!)
            } else {
                call.respondText("Hello World!")
            }
        }

        post("/") {
            root.value = call.receive()
            call.respond(200)
        }
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}
