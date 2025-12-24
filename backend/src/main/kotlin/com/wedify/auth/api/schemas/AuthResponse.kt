package com.wedify.auth.api.schemas

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val success: Boolean,
    val user: AuthUserInfo? = null,
    val message: String? = null,
    val error: String? = null
)
