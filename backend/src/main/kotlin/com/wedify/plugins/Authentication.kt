package com.wedify.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.wedify.config.AppConfig
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import org.koin.ktor.ext.inject

fun Application.configureAuthentication() {
    val config by inject<AppConfig>()

    install(Authentication) {
        jwt("supabase-jwt") {
            realm = "wedify"

            verifier(
                JWT.require(Algorithm.HMAC256(config.supabase.jwtSecret))
                    .withIssuer("https://${config.supabase.projectRef}.supabase.co/auth/v1")
                    .build()
            )

            validate { credential ->
                val userId = credential.payload.subject
                val email = credential.payload.getClaim("email").asString()
                val role = credential.payload.getClaim("role").asString()

                if (userId != null) {
                    UserPrincipal(
                        id = userId,
                        email = email ?: "",
                        role = role ?: "authenticated"
                    )
                } else {
                    null
                }
            }

            challenge { _, _ ->
                call.respond(HttpStatusCode.Unauthorized, mapOf("error" to "Invalid or expired token"))
            }
        }
    }
}

data class UserPrincipal(
    val id: String,
    val email: String,
    val role: String
) : Principal
