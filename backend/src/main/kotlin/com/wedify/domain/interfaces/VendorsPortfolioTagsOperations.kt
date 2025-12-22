package com.wedify.domain.interfaces

import com.wedify.domain.models.VendorsPortfolioTags

interface VendorsPortfolioTagsOperations {
    suspend fun tagVendorPortfolio(tag: VendorsPortfolioTags): VendorsPortfolioTags
    suspend fun untagVendorPortfolio(tagId: String): VendorsPortfolioTags?
    suspend fun deleteTagsForVendor(vendorId: String): Int
    suspend fun getTaggedVendorForFile(fileId: String): List<VendorsPortfolioTags>
}
