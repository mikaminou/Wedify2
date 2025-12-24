package com.wedify.vendors.domain.schemas

import com.wedify.vendors.domain.models.VendorPackages
import com.wedify.vendors.domain.models.VendorPromotions
import com.wedify.vendors.domain.models.VendorRegions
import com.wedify.vendors.domain.models.Vendors
import com.wedify.vendors.domain.models.VendorsPortfolioTags
import com.wedify.vendors.domain.models.VendorsRestDays
import kotlinx.serialization.Serializable

@Serializable
data class BusinessDataRequest(
    val basicInfo: Vendors,
    val regions: List<VendorRegions>,
    val packages: List<VendorPackages>,
    val promotions: List<VendorPromotions>,
    val restDays: List<VendorsRestDays>,
    val portfolioTags: List<VendorsPortfolioTags>?,
)
