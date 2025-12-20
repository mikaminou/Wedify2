package com.wedify.plugins

import io.ktor.server.application.Application
import io.ktor.server.plugins.openapi.openAPI
import io.ktor.server.routing.routing

fun Application.configureOpenAPI() {
    routing {
        openAPI(path = "openapi", swaggerFile = "openapi/documentation.yaml")
    }
}
