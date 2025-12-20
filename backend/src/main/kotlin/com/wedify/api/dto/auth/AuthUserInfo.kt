package com.wedify.api.dto.auth

import kotlinx.serialization.Serializable

@Serializable
data class AuthUserInfo(
    val id: String,
    val email: String? = null,
    val phone: String? = null,
    val createdAt: String? = null,
    val confirmedAt: String? = null
)
