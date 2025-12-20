package com.wedify.config

import io.ktor.server.application.Application

data class AppConfig(
    val environment: String,
    val supabase: SupabaseConfig,
    val corsHosts: List<String>,
    val redis: RedisConfig?
)

data class SupabaseConfig(
    val url: String,
    val anonKey: String,
    val serviceRoleKey: String,
    val jwtSecret: String,
    val projectRef: String
)

data class RedisConfig(
    val url: String
)

fun Application.loadAppConfig(): AppConfig {
    val config = environment.config
    val supabaseUrl = config.property("app.supabase.url").getString()

    return AppConfig(
        environment = config.property("app.environment").getString(),
        supabase = SupabaseConfig(
            url = supabaseUrl,
            anonKey = config.property("app.supabase.anonKey").getString(),
            serviceRoleKey = config.property("app.supabase.serviceRoleKey").getString(),
            jwtSecret = config.property("app.supabase.jwtSecret").getString(),
            projectRef = supabaseUrl.removePrefix("https://").removeSuffix(".supabase.co")
        ),
        redis = config.propertyOrNull("app.redis.url")?.getString()?.let {
            RedisConfig(url = it)
        },
        corsHosts = config.property("app.cors.allowedHosts").getList(),
    )
}
