package com.wedify.plugins

import com.wedify.config.AppConfig
import com.wedify.auth.infrastructure.AuthService
import com.wedify.config.supabase.SupabaseClientProvider
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin(appConfig: AppConfig) {
    install(Koin) {
        slf4jLogger()
        modules(appModule(appConfig))
    }
}

fun appModule(appConfig: AppConfig) = module {
    single { appConfig }
    single { SupabaseClientProvider(get()) }
    single { AuthService(get()) }
}
