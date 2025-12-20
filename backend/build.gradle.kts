plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.serialization") version "1.9.25"
    id("io.ktor.plugin") version "2.3.12"
}

group = "com.wedify"
version = "0.0.1"

application {
    mainClass.set("com.wedify.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    // Ktor Server
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.auth.jwt)
    implementation(libs.ktor.server.status.pages)
    implementation(libs.ktor.server.call.logging)
    implementation(libs.ktor.server.config.yaml)

    // Serialization
    implementation(libs.ktor.serialization.kotlinx.json)

    // Ktor Client (for Supabase)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.content.negotiation)

    // Supabase Kotlin SDK
    implementation(platform(libs.supabase.bom))
    implementation(libs.supabase.postgrest)
    implementation(libs.supabase.gotrue)
    implementation(libs.supabase.storage)
    implementation(libs.supabase.realtime)

    // Koin for Dependency Injection
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger.slf4j)

    // Logging
    implementation(libs.logback.classic)

    // OpenAPI & Swagger
    implementation(libs.ktor.server.openapi)

    // Testing
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.koin.test)
}
