package com.wedify.api.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class LoginEmailRequest(
    val email: String,
    val password: String,
)
