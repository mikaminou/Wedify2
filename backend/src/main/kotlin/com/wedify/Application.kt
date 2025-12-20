package com.wedify

import com.wedify.config.loadAppConfig
import com.wedify.plugins.configureAuthentication
import com.wedify.plugins.configureCORS
import com.wedify.plugins.configureKoin
import com.wedify.plugins.configureOpenAPI
import com.wedify.plugins.configureRouting
import com.wedify.plugins.configureSerialization
import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>) {
    EngineMain.main(args)
}

// Application module function called by Ktor from application.conf
fun Application.module() {
    val appConfig = loadAppConfig()

    configureKoin(appConfig)
    configureSerialization()
    configureCORS()
    configureAuthentication()
    configureOpenAPI()
    configureRouting()
}
