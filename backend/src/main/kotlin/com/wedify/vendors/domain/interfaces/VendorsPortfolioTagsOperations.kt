package com.wedify.vendors.domain.interfaces

import com.wedify.vendors.domain.models.VendorsPortfolioTags

interface VendorsPortfolioTagsOperations {
    suspend fun tagVendorPortfolio(tag: VendorsPortfolioTags): VendorsPortfolioTags
    suspend fun tagVendorPortfoliosBatch(tags: List<VendorsPortfolioTags>): List<VendorsPortfolioTags>
    suspend fun untagVendorPortfolio(tagId: String): VendorsPortfolioTags?
    suspend fun deleteTagsForVendor(vendorId: String): Int
    suspend fun getTaggedVendorForFile(fileId: String): List<VendorsPortfolioTags>
}
