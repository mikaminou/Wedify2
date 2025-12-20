package com.wedify.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.wedify.config.AppConfig
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication
import io.ktor.server.auth.jwt.jwt
import io.ktor.server.response.respond
import org.koin.ktor.ext.inject
import java.security.Principal

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
) : Principal {
    override fun getName(): String? {
        return email
    }
}
