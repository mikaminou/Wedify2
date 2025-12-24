package com.wedify.vendors.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Vendors(
    val userId: String,
    val serviceTypeId: String,
    val businessName: String,
    val description: String?,
    val rating: Float?,
    val reviewCount: Int?,
    val id: String?,
)
