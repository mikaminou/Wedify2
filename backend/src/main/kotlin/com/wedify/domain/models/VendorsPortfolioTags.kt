package com.wedify.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class VendorsPortfolioTags(
    val vendorId: String,
    val taggedVendorId: String,
    val fileId: String,
    val id: String?,
)
