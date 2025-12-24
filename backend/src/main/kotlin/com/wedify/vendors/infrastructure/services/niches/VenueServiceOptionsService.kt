package com.wedify.vendors.infrastructure.services.niches

import com.wedify.vendors.domain.interfaces.niches.VenueServiceOptionsOperations
import com.wedify.vendors.domain.models.niches.VenueServiceOptions
import com.wedify.config.supabase.SupabaseClientProvider
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.slf4j.LoggerFactory

class VenueServiceOptionsService(
    private val supabaseClientProvider: SupabaseClientProvider,
) : VenueServiceOptionsOperations {

    private val client: SupabaseClient
        get() = supabaseClientProvider.client

    private val logger = LoggerFactory.getLogger(VenueServiceOptionsService::class.java)

    override suspend fun createVenueServiceOptions(options: VenueServiceOptions): VenueServiceOptions {
        logger.info("Creating venue service options: $options")
        return client.from("venue_service_options").insert(options) {
            select()
        }.decodeSingle<VenueServiceOptions>()
    }

    override suspend fun updateVenueServiceOptions(
        optionsId: String,
        options: VenueServiceOptions
    ): VenueServiceOptions? {
        logger.info("Updating venue service options: $optionsId with data: $options")
        return client.from("venue_service_options").update(options) {
            select()
            filter { eq("id", optionsId) }
        }.decodeSingleOrNull<VenueServiceOptions>()
    }

    override suspend fun deleteVenueServiceOptions(optionsId: String): VenueServiceOptions? {
        logger.info("Deleting venue service options: $optionsId")
        return client.from("venue_service_options").delete {
            select()
            filter { eq("id", optionsId) }
        }.decodeSingleOrNull<VenueServiceOptions>()
    }

    override suspend fun deleteVenueServiceOptionsForVendor(vendorId: String): Int {
        logger.info("Deleting venue service options for vendor: $vendorId")
        val response = client.from("venue_service_options").delete {
            filter { eq("vendor_id", vendorId) }
        }
        return response.countOrNull()?.toInt() ?: 0
    }

    override suspend fun getVenueServiceOptions(optionsId: String): VenueServiceOptions? {
        logger.info("Fetching venue service options for id={}", optionsId)
        return client.from("venue_service_options")
            .select { filter { eq("id", optionsId) } }
            .decodeSingleOrNull<VenueServiceOptions>()
    }

    override suspend fun getVenueServiceOptionsForVendor(vendorId: String): List<VenueServiceOptions> {
        logger.info("Fetching venue service options for vendorId={}", vendorId)
        return client.from("venue_service_options")
            .select { filter { eq("vendor_id", vendorId) } }
            .decodeList<VenueServiceOptions>()
    }
}
