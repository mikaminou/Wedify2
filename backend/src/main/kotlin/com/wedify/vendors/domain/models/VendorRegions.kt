package com.wedify.vendors.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class VendorRegions(
    val vendorId: String,
    val regionName: String,
    val id: String? = null,
)
