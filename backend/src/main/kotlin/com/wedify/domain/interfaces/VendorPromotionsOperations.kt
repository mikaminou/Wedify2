package com.wedify.domain.interfaces

import com.wedify.domain.models.VendorPromotions

interface VendorPromotionsOperations {
    suspend fun createVendorPromotion(promotion: VendorPromotions): VendorPromotions
    suspend fun updateVendorPromotion(promotionId: String, promotion: VendorPromotions): VendorPromotions?
    suspend fun deleteVendorPromotion(promotionId: String): VendorPromotions?
    suspend fun deleteVendorPromotions(vendorId: String): Int
    suspend fun getVendorPromotion(promotionId: String): VendorPromotions?
    suspend fun getVendorPromotions(vendorId: String): List<VendorPromotions>
}
