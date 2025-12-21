package com.wedify.domain.services

import com.wedify.api.dto.auth.AuthResponse
import com.wedify.api.dto.auth.LoginEmailRequest
import com.wedify.api.dto.auth.LoginPhoneRequest
import com.wedify.api.dto.auth.PhoneChannel
import com.wedify.api.dto.auth.SignUpEmailRequest
import com.wedify.api.dto.auth.SignUpPhoneRequest
import com.wedify.domain.mappers.toAuthUserInfo
import com.wedify.infrastructure.supabase.SupabaseClientProvider
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.providers.builtin.Phone
import io.github.jan.supabase.auth.status.SessionStatus
import org.slf4j.LoggerFactory

class AuthService(
    private val supabaseClientProvider: SupabaseClientProvider
) {
    private val auth: Auth
        get() = supabaseClientProvider.client.auth
    private val logger = LoggerFactory.getLogger(AuthService::class.java)

    suspend fun signUpWithEmail(request: SignUpEmailRequest): AuthResponse {
        return try {
            val result = auth.signUpWith(Email, redirectUrl = request.redirectUrl) {
                email = request.email
                password = request.password
                request.data?.let { data = it }
            }
            AuthResponse(
                success = true,
                user = result?.toAuthUserInfo(),
                message = if (result == null) "User created and logged in" else "User created, email confirmation required"
            )
        } catch (e: Exception) {
            AuthResponse(success = false, error = e.message)
        }
    }

    suspend fun signUpWithPhone(request: SignUpPhoneRequest): AuthResponse {
        return try {
            val result = auth.signUpWith(Phone) {
                phone = request.phone
                password = request.password
                channel = when (request.channel) {
                    PhoneChannel.WHATSAPP -> Phone.Channel.WHATSAPP
                    PhoneChannel.SMS -> Phone.Channel.SMS
                }
            }
            AuthResponse(
                success = true,
                user = result?.toAuthUserInfo(),
                message = if (result == null) "User created and logged in" else "User created, phone confirmation required"
            )
        } catch (e: Exception) {
            AuthResponse(success = false, error = e.message)
        }
    }

    suspend fun loginWithEmail(request: LoginEmailRequest): AuthResponse {
        return handleSignIn(request.email) {
            auth.signInWith(Email) {
                email = request.email
                password = request.password
            }
        }
    }

    suspend fun loginWithPhone(request: LoginPhoneRequest): AuthResponse {
        return handleSignIn(request.phone) {
            auth.signInWith(Phone) {
                phone = request.phone
                password = request.password
            }
        }
    }

    private suspend fun handleSignIn(identifier: String? = null, onSignIn: suspend () -> Unit): AuthResponse {
        return try {
            onSignIn()

            val status = auth.sessionStatus.value
            val user = if (status is SessionStatus.Authenticated) status.session.user else null

            if (user == null) {
                logger.info("Sign-in failed for identifier=${identifier ?: "unknown"}: no authenticated session")
                AuthResponse(success = false, error = "Authentication failed or confirmation required")
            } else {
                AuthResponse(
                    success = true,
                    user = user.toAuthUserInfo(),
                    message = "User logged in successfully"
                )
            }
        } catch (e: Throwable) {
            logger.error("Sign-in error for identifier=${identifier ?: "unknown"}", e)
            AuthResponse(success = false, error = e.message ?: "Unknown error")
        }
    }
}
