package com.wedify.vendors.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class VendorPackages(
    val vendorId: String,
    val packageName: String,
    val price: Double,
    val features: List<String>,
    val description: String? = null,
    val isDailyBooking: Boolean? = null,
    val hourRange: Int? = null,
    val hasMultipleBookings: Boolean? = null,
    val id: String? = null,
)
