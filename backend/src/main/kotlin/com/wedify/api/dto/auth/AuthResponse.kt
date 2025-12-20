package com.wedify.api.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val success: Boolean,
    val user: AuthUserInfo? = null,
    val message: String? = null,
    val error: String? = null
)
