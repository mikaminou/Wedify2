package com.wedify.auth.api.schemas

import kotlinx.serialization.Serializable

@Serializable
data class LoginPhoneRequest(
    val phone: String,
    val password: String,
)
