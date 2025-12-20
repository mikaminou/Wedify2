package com.wedify.infrastructure.supabase

import com.wedify.config.AppConfig
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

class SupabaseClientProvider(private val config: AppConfig) {

    val client: SupabaseClient by lazy {
        createSupabaseClient(
            supabaseUrl = config.supabase.url,
            supabaseKey = config.supabase.serviceRoleKey
        ) {
            install(Postgrest)
            install(Storage)
            install(Auth)
        }
    }
}
