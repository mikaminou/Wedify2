package com.wedify.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class VendorPackages(
    val vendorId: String,
    val packageName: String,
    val price: Double,
    val features: List<String>,
    val description: String?,
    val isDailyBooking: Boolean?,
    val hourRange: Int?,
    val hasMultipleBookings: Boolean?,
    val id: String?,
)
