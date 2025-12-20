plugins {
    kotlin("jvm") version "2.2.0"
    kotlin("plugin.serialization") version "2.2.0"
    id("io.ktor.plugin") version "3.2.2"
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
    // Use Ktor BOM first to align all Ktor modules
    implementation(platform(libs.ktor.bom))

    // Use Supabase BOM to align Supabase SDK modules to 3.2.0
    implementation(platform(libs.supabase.bom))

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
    implementation(libs.kotlinx.coroutines.core)

    // Serialization
    implementation(libs.ktor.serialization.kotlinx.json)

    // Ktor Client (for Supabase)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.content.negotiation)

    // Supabase Kotlin SDK (versions controlled by supabase BOM)
    implementation(libs.supabase.postgrest)
    implementation(libs.supabase.auth)
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

// Optional: force Ktor group artifacts to the katalog version if transitive libs pull different Ktor versions
configurations.all {
    resolutionStrategy.eachDependency {
        if (requested.group == "io.ktor") {
            useVersion(libs.versions.ktor.get())
            because("Enforce Ktor ${libs.versions.ktor.get()} to match Supabase/Ktor BOM")
        }
    }
}
