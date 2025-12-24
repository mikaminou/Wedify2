package com.wedify.auth.api.routes

import com.wedify.auth.api.schemas.ForgotPasswordRequest
import com.wedify.auth.api.schemas.LoginEmailRequest
import com.wedify.auth.api.schemas.LoginPhoneRequest
import com.wedify.auth.api.schemas.SignUpEmailRequest
import com.wedify.auth.api.schemas.SignUpPhoneRequest
import com.wedify.auth.api.schemas.UpdatePasswordRequest
import com.wedify.auth.infrastructure.AuthService
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.patch
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import org.koin.ktor.ext.inject

fun Route.authRoutes() {
    val authService by inject<AuthService>()

    route("/auth") {
        post("/signup/email") {
            val request = call.receive<SignUpEmailRequest>()
            val response = authService.signUpWithEmail(request)
            call.respond(response)
        }
        post("/signup/phone") {
            val request = call.receive<SignUpPhoneRequest>()
            val response = authService.signUpWithPhone(request)
            call.respond(response)
        }
        post("/login/phone") {
            val request = call.receive<LoginPhoneRequest>()
            val response = authService.loginWithPhone(request)
            call.respond(response)
        }

        post("/login/email") {
            val request = call.receive<LoginEmailRequest>()
            val response = authService.loginWithEmail(request)
            call.respond(response)
        }

        post("/forgot-password") {
            val request = call.receive<ForgotPasswordRequest>()
            val response = authService.forgotPassword(request)
            call.respond(response)
        }

        patch("/update-password") {
            val request = call.receive<UpdatePasswordRequest>()
            val response = authService.updatePassword(request)
            call.respond(response)
        }
    }
}
