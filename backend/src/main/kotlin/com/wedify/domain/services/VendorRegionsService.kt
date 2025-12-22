package com.wedify.domain.services

import com.wedify.domain.interfaces.VendorRegionsOperations
import com.wedify.domain.models.VendorRegions
import com.wedify.infrastructure.supabase.SupabaseClientProvider
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.slf4j.LoggerFactory

class VendorRegionsService(
    private val supabaseClientProvider: SupabaseClientProvider,
): VendorRegionsOperations {

    private val client: SupabaseClient
        get() = supabaseClientProvider.client

    private val logger = LoggerFactory.getLogger(VendorRegionsService::class.java)

    override suspend fun addVendorRegion(vendorRegion: VendorRegions): VendorRegions {
        logger.info("Adding vendor region: $vendorRegion")
        return client.from("vendor_regions").insert(vendorRegion) {
            select()
        }.decodeSingle<VendorRegions>()
    }

    override suspend fun removeVendorRegion(vendorRegionId: String): VendorRegions? {
        logger.info("Removing vendor region: $vendorRegionId")
        return client.from("vendor_regions").delete {
            select()
            filter {
                eq("id", vendorRegionId)
            }
        }.decodeSingleOrNull<VendorRegions>()
    }

    override suspend fun removeVendorRegions(vendorId: String): Int {
        logger.info("Removing vendor regions for vendor: $vendorId")
        val response = client.from("vendor_regions").delete {
            filter {
                eq("vendor_id", vendorId)
            }
        }
        val deletedCount = response.countOrNull()?.toInt() ?: 0
        return deletedCount
    }

    override suspend fun getVendorRegions(vendorId: String): List<VendorRegions> {
        logger.info("Fetching vendor regions for vendorId={}", vendorId)
        return client.from("vendor_regions")
            .select {
                filter {
                    eq("vendor_id", vendorId)
                }
            }
            .decodeList<VendorRegions>()
    }
}
