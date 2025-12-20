package com.wedify.plugins

import com.wedify.config.AppConfig
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.cors.routing.CORS
import org.koin.ktor.ext.inject
import kotlin.getValue

fun Application.configureCORS() {
    val appConfig by inject<AppConfig>()

    install(CORS) {
        allowMethod(HttpMethod.Options)
        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Post)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Delete)
        allowMethod(HttpMethod.Patch)

        allowHeader(HttpHeaders.Authorization)
        allowHeader(HttpHeaders.ContentType)
        allowHeader(HttpHeaders.AccessControlAllowOrigin)
        allowHeader("X-Requested-With")

        appConfig.corsHosts.forEach { host ->
            allowHost(host.removePrefix("https://").removePrefix("http://"),
                schemes = listOf("http", "https"))
        }

        allowCredentials = true
        allowNonSimpleContentTypes = true
    }
}
