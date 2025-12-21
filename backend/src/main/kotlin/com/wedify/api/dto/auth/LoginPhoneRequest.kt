package com.wedify.api.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class LoginPhoneRequest(
    val phone: String,
    val password: String,
)
