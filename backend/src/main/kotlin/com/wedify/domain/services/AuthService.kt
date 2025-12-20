package com.wedify.domain.services

import com.wedify.api.dto.auth.AuthResponse
import com.wedify.api.dto.auth.PhoneChannel
import com.wedify.api.dto.auth.SignUpEmailRequest
import com.wedify.api.dto.auth.SignUpPhoneRequest
import com.wedify.domain.mappers.toAuthUserInfo
import com.wedify.infrastructure.supabase.SupabaseClientProvider
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.providers.builtin.Phone

class AuthService(
    private val supabaseClientProvider: SupabaseClientProvider
) {
    private val auth: Auth
        get() = supabaseClientProvider.client.auth

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
}
