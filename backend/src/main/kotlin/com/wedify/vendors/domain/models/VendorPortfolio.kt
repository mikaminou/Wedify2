package com.wedify.vendors.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class VendorPortfolio(
    val images: List<String>,
    val videos: List<String>,
    val tags: List<VendorsPortfolioTags>,
)
