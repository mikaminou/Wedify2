package com.wedify.vendors.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Vendors(
    val userId: String,
    val serviceTypeId: String,
    val businessName: String,
    val description: String? = null,
    val rating: Float? = null,
    val reviewCount: Int? = null,
    val id: String? = null,
)
