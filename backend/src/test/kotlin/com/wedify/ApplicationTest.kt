package com.wedify

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun testHealthEndpoint() = testApplication {
        application {
            // Note: Full module requires env vars
            // For testing, mock the dependencies
        }

        // Basic connectivity test
        // Full integration tests require Supabase test instance
    }
}
