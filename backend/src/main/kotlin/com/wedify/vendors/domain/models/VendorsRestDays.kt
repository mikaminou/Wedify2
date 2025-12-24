package com.wedify.vendors.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class VendorsRestDays(
    val vendorId: String,
    val dayOfWeek: String,
    val id: String?,
)
