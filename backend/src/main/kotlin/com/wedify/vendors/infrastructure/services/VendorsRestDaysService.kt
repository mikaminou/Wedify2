package com.wedify.vendors.infrastructure.services

import com.wedify.vendors.domain.interfaces.VendorsRestDaysOperations
import com.wedify.vendors.domain.models.VendorsRestDays
import com.wedify.config.supabase.SupabaseClientProvider
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.slf4j.LoggerFactory

class VendorsRestDaysService(
    private val supabaseClient: SupabaseClientProvider,
): VendorsRestDaysOperations {

    private val client: SupabaseClient
        get() = supabaseClient.client

    private val logger = LoggerFactory.getLogger(VendorsPortfolioTagsService::class.java)

    override suspend fun createVendorRestDay(vendorRestDays: VendorsRestDays): VendorsRestDays {
        logger.info("Creating vendor rest days for $vendorRestDays")
        return client.from("vendors_rest_days").insert(vendorRestDays) {
            select()
        }.decodeSingle<VendorsRestDays>()
    }

    override suspend fun removeVendorRestDay(vendorRestDayId: String): VendorsRestDays? {
        logger.info("Removing vendor rest day with id: $vendorRestDayId")
        return client.from("vendors_rest_days").delete {
            select()
            filter {
                eq("id", vendorRestDayId)
            }
        }.decodeSingleOrNull<VendorsRestDays>()
    }

    override suspend fun removeVendorRestDays(vendorId: String): Int {
        logger.info("Removing all rest days for vendor with id: $vendorId")
        val response = client.from("vendors_rest_days").delete {
            filter {
                eq("vendor_id", vendorId)
            }
        }
        val deletedCount = response.countOrNull()?.toInt() ?: 0
        return deletedCount
    }

    override suspend fun getVendorRestDays(vendorId: String): List<VendorsRestDays> {
        logger.info("Fetching rest days for vendor with id: $vendorId")
        return client.from("vendors_rest_days")
            .select {
                filter {
                    eq("vendor_id", vendorId)
                }
            }
            .decodeList<VendorsRestDays>()
    }
}
