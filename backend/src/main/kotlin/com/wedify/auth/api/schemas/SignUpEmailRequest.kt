package com.wedify.auth.api.schemas

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class SignUpEmailRequest(
    val email: String,
    val password: String,
    val redirectUrl: String? = null,
    val data: JsonObject? = null
)
