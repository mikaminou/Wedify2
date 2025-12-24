package com.wedify.auth.api.schemas

import kotlinx.serialization.Serializable

@Serializable
data class LoginEmailRequest(
    val email: String,
    val password: String,
)
