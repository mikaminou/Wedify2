package com.wedify.api.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class ForgotPasswordRequest(
    val email: String,
    val redirectUrl: String?
)
