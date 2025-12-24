package com.wedify.auth.api.schemas

import kotlinx.serialization.Serializable

@Serializable
data class ForgotPasswordRequest(
    val email: String,
    val redirectUrl: String?
)
