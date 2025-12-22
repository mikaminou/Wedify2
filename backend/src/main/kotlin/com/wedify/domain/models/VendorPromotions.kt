package com.wedify.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class VendorPromotions(
    val vendorId: String,
    val name: String,
    val originalPrice: Double,
    val discountPrice: Double,
    val startDate: String,
    val endDate: String,
    val id: String?,
    val packageId: String?,
    val description: String?,
    val benefits: List<String>?,
    val features: List<String>?,
)
