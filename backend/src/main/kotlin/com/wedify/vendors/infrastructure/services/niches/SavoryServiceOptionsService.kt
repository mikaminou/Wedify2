package com.wedify.vendors.infrastructure.services.niches

import com.wedify.vendors.domain.interfaces.niches.SavoryServiceOptionsOperations
import com.wedify.vendors.domain.models.niches.SavoryServiceOptions
import com.wedify.config.supabase.SupabaseClientProvider
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.slf4j.LoggerFactory

class SavoryServiceOptionsService(
    private val supabaseClientProvider: SupabaseClientProvider,
) : SavoryServiceOptionsOperations {

    private val client: SupabaseClient
        get() = supabaseClientProvider.client

    private val logger = LoggerFactory.getLogger(SavoryServiceOptionsService::class.java)

    override suspend fun createSavoryServiceOptions(options: SavoryServiceOptions): SavoryServiceOptions {
        logger.info("Creating savory service options: $options")
        return client.from("savory_service_options").insert(options) {
            select()
        }.decodeSingle<SavoryServiceOptions>()
    }

    override suspend fun updateSavoryServiceOptions(
        optionsId: String,
        options: SavoryServiceOptions
    ): SavoryServiceOptions? {
        logger.info("Updating savory service options: $optionsId with data: $options")
        return client.from("savory_service_options").update(options) {
            select()
            filter { eq("id", optionsId) }
        }.decodeSingleOrNull<SavoryServiceOptions>()
    }

    override suspend fun deleteSavoryServiceOptions(optionsId: String): SavoryServiceOptions? {
        logger.info("Deleting savory service options: $optionsId")
        return client.from("savory_service_options").delete {
            select()
            filter { eq("id", optionsId) }
        }.decodeSingleOrNull<SavoryServiceOptions>()
    }

    override suspend fun deleteSavoryServiceOptionsForVendor(vendorId: String): Int {
        logger.info("Deleting savory service options for vendor: $vendorId")
        val response = client.from("savory_service_options").delete {
            filter { eq("vendor_id", vendorId) }
        }
        return response.countOrNull()?.toInt() ?: 0
    }

    override suspend fun getSavoryServiceOptions(optionsId: String): SavoryServiceOptions? {
        logger.info("Fetching savory service options for id={}", optionsId)
        return client.from("savory_service_options")
            .select { filter { eq("id", optionsId) } }
            .decodeSingleOrNull<SavoryServiceOptions>()
    }

    override suspend fun getSavoryServiceOptionsForVendor(vendorId: String): List<SavoryServiceOptions> {
        logger.info("Fetching savory service options for vendorId={}", vendorId)
        return client.from("savory_service_options")
            .select { filter { eq("vendor_id", vendorId) } }
            .decodeList<SavoryServiceOptions>()
    }
}
