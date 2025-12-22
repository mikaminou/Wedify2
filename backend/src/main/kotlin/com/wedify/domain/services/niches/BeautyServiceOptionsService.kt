package com.wedify.domain.services.niches

import com.wedify.domain.interfaces.niches.BeautyServiceOptionsOperations
import com.wedify.domain.models.niches.BeautyServiceOptions
import com.wedify.infrastructure.supabase.SupabaseClientProvider
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.slf4j.LoggerFactory

class BeautyServiceOptionsService(
    private val supabaseClientProvider: SupabaseClientProvider,
) : BeautyServiceOptionsOperations {

    private val client: SupabaseClient
        get() = supabaseClientProvider.client

    private val logger = LoggerFactory.getLogger(BeautyServiceOptionsService::class.java)

    override suspend fun createBeautyServiceOptions(options: BeautyServiceOptions): BeautyServiceOptions {
        logger.info("Creating beauty service options: $options")
        return client.from("beauty_service_options").insert(options) {
            select()
        }.decodeSingle<BeautyServiceOptions>()
    }

    override suspend fun updateBeautyServiceOptions(
        optionsId: String,
        options: BeautyServiceOptions
    ): BeautyServiceOptions? {
        logger.info("Updating beauty service options: $optionsId with data: $options")
        return client.from("beauty_service_options").update(options) {
            select()
            filter { eq("id", optionsId) }
        }.decodeSingleOrNull<BeautyServiceOptions>()
    }

    override suspend fun deleteBeautyServiceOptions(optionsId: String): BeautyServiceOptions? {
        logger.info("Deleting beauty service options: $optionsId")
        return client.from("beauty_service_options").delete {
            select()
            filter { eq("id", optionsId) }
        }.decodeSingleOrNull<BeautyServiceOptions>()
    }

    override suspend fun deleteBeautyServiceOptionsForVendor(vendorId: String): Int {
        logger.info("Deleting beauty service options for vendor: $vendorId")
        val response = client.from("beauty_service_options").delete {
            filter { eq("vendor_id", vendorId) }
        }
        return response.countOrNull()?.toInt() ?: 0
    }

    override suspend fun getBeautyServiceOptions(optionsId: String): BeautyServiceOptions? {
        logger.info("Fetching beauty service options for id={}", optionsId)
        return client.from("beauty_service_options")
            .select { filter { eq("id", optionsId) } }
            .decodeSingleOrNull<BeautyServiceOptions>()
    }

    override suspend fun getBeautyServiceOptionsForVendor(vendorId: String): List<BeautyServiceOptions> {
        logger.info("Fetching beauty service options for vendorId={}", vendorId)
        return client.from("beauty_service_options")
            .select { filter { eq("vendor_id", vendorId) } }
            .decodeList<BeautyServiceOptions>()
    }
}
