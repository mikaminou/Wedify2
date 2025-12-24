package com.wedify.vendors.infrastructure.services

import com.wedify.vendors.domain.interfaces.VendorPromotionsOperations
import com.wedify.vendors.domain.models.VendorPromotions
import com.wedify.config.supabase.SupabaseClientProvider
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.slf4j.LoggerFactory

class VendorPromotionsService(
    val supabaseClientProvider: SupabaseClientProvider,
): VendorPromotionsOperations {
    private val client : SupabaseClient
        get() = supabaseClientProvider.client
    private val logger = LoggerFactory.getLogger(VendorPromotionsService::class.java)

    override suspend fun createVendorPromotion(promotion: VendorPromotions): VendorPromotions {
        logger.info("Creating vendor promotion: $promotion")
        return client.from("vendor_promotions").insert(promotion) {
            select()
        }.decodeSingle<VendorPromotions>()
    }

    override suspend fun updateVendorPromotion(
        promotionId: String,
        promotion: VendorPromotions
    ): VendorPromotions? {
        logger.info("Updating vendor promotion: $promotionId with data: $promotion")
        return client.from("vendor_promotions").update(promotion) {
            select()
            filter {
                eq("id", promotionId)
            }
        }.decodeSingleOrNull<VendorPromotions>()
    }

    override suspend fun deleteVendorPromotion(promotionId: String): VendorPromotions? {
        logger.info("Deleting vendor promotion: $promotionId")
        return client.from("vendor_promotions").delete {
            select()
            filter {
                eq("id", promotionId)
            }
        }.decodeSingleOrNull<VendorPromotions>()
    }

    override suspend fun deleteVendorPromotions(vendorId: String): Int {
        logger.info("Deleting vendor promotions for vendor: $vendorId")
        val response = client.from("vendor_promotions").delete {
            filter {
                eq("vendor_id", vendorId)
            }
        }
        val deletedCount = response.countOrNull()?.toInt() ?: 0
        return deletedCount
    }

    override suspend fun getVendorPromotion(promotionId: String): VendorPromotions? {
        logger.info("Fetching vendor promotion for id={}", promotionId)
        return client.from("vendor_promotions")
            .select{
                filter {
                    eq("id", promotionId)
                }
            }
            .decodeSingleOrNull<VendorPromotions>()
    }

    override suspend fun getVendorPromotions(vendorId: String): List<VendorPromotions> {
        logger.info("Fetching vendor promotions for vendorId={}", vendorId)
        return client.from("vendor_promotions")
            .select{
                filter {
                    eq("vendor_id", vendorId)
                }
            }
            .decodeList<VendorPromotions>()
    }
}
