package com.wedify.vendors.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class BusinessData(
    val basicInfo: Vendors,
    val regions: List<VendorRegions>,
    val portfolio: VendorPortfolio,
    val packages: List<VendorPackages>,
    val promotions: List<VendorPromotions>,
    val restDays: List<VendorsRestDays>,
)
