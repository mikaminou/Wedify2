package com.wedify.vendors.infrastructure.services.niches

import com.wedify.vendors.domain.interfaces.niches.TransportationServiceOptionsOperations
import com.wedify.vendors.domain.models.niches.TransportationServiceOptions
import com.wedify.config.supabase.SupabaseClientProvider
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.slf4j.LoggerFactory

class TransportationServiceOptionsService(
    private val supabaseClientProvider: SupabaseClientProvider,
) : TransportationServiceOptionsOperations {

    private val client: SupabaseClient
        get() = supabaseClientProvider.client

    private val logger = LoggerFactory.getLogger(TransportationServiceOptionsService::class.java)

    override suspend fun createTransportationServiceOptions(options: TransportationServiceOptions): TransportationServiceOptions {
        logger.info("Creating transportation service options: $options")
        return client.from("transportation_service_options").insert(options) {
            select()
        }.decodeSingle<TransportationServiceOptions>()
    }

    override suspend fun updateTransportationServiceOptions(
        optionsId: String,
        options: TransportationServiceOptions
    ): TransportationServiceOptions? {
        logger.info("Updating transportation service options: $optionsId with data: $options")
        return client.from("transportation_service_options").update(options) {
            select()
            filter { eq("id", optionsId) }
        }.decodeSingleOrNull<TransportationServiceOptions>()
    }

    override suspend fun deleteTransportationServiceOptions(optionsId: String): TransportationServiceOptions? {
        logger.info("Deleting transportation service options: $optionsId")
        return client.from("transportation_service_options").delete {
            select()
            filter { eq("id", optionsId) }
        }.decodeSingleOrNull<TransportationServiceOptions>()
    }

    override suspend fun deleteTransportationServiceOptionsForVendor(vendorId: String): Int {
        logger.info("Deleting transportation service options for vendor: $vendorId")
        val response = client.from("transportation_service_options").delete {
            filter { eq("vendor_id", vendorId) }
        }
        return response.countOrNull()?.toInt() ?: 0
    }

    override suspend fun getTransportationServiceOptions(optionsId: String): TransportationServiceOptions? {
        logger.info("Fetching transportation service options for id={}", optionsId)
        return client.from("transportation_service_options")
            .select { filter { eq("id", optionsId) } }
            .decodeSingleOrNull<TransportationServiceOptions>()
    }

    override suspend fun getTransportationServiceOptionsForVendor(vendorId: String): List<TransportationServiceOptions> {
        logger.info("Fetching transportation service options for vendorId={}", vendorId)
        return client.from("transportation_service_options")
            .select { filter { eq("vendor_id", vendorId) } }
            .decodeList<TransportationServiceOptions>()
    }
}
