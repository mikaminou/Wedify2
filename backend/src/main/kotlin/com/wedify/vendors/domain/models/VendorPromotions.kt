package com.wedify.vendors.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class VendorPromotions(
    val vendorId: String,
    val name: String,
    val originalPrice: Double,
    val discountPrice: Double,
    val startDate: String,
    val endDate: String,
    val id: String? = null,
    val packageId: String? = null,
    val description: String? = null,
    val benefits: List<String>? = null,
    val features: List<String>? = null,
)
