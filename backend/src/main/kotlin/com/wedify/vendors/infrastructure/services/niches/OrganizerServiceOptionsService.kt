package com.wedify.vendors.infrastructure.services.niches

import com.wedify.vendors.domain.interfaces.niches.OrganizerServiceOptionsOperations
import com.wedify.vendors.domain.models.niches.OrganizerServiceOptions
import com.wedify.config.supabase.SupabaseClientProvider
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.slf4j.LoggerFactory

class OrganizerServiceOptionsService(
    private val supabaseClientProvider: SupabaseClientProvider,
) : OrganizerServiceOptionsOperations {

    private val client: SupabaseClient
        get() = supabaseClientProvider.client

    private val logger = LoggerFactory.getLogger(OrganizerServiceOptionsService::class.java)

    override suspend fun createOrganizerServiceOptions(options: OrganizerServiceOptions): OrganizerServiceOptions {
        logger.info("Creating organizer service options: $options")
        return client.from("organizer_service_options").insert(options) {
            select()
        }.decodeSingle<OrganizerServiceOptions>()
    }

    override suspend fun updateOrganizerServiceOptions(
        optionsId: String,
        options: OrganizerServiceOptions
    ): OrganizerServiceOptions? {
        logger.info("Updating organizer service options: $optionsId with data: $options")
        return client.from("organizer_service_options").update(options) {
            select()
            filter { eq("id", optionsId) }
        }.decodeSingleOrNull<OrganizerServiceOptions>()
    }

    override suspend fun deleteOrganizerServiceOptions(optionsId: String): OrganizerServiceOptions? {
        logger.info("Deleting organizer service options: $optionsId")
        return client.from("organizer_service_options").delete {
            select()
            filter { eq("id", optionsId) }
        }.decodeSingleOrNull<OrganizerServiceOptions>()
    }

    override suspend fun deleteOrganizerServiceOptionsForVendor(vendorId: String): Int {
        logger.info("Deleting organizer service options for vendor: $vendorId")
        val response = client.from("organizer_service_options").delete {
            filter { eq("vendor_id", vendorId) }
        }
        return response.countOrNull()?.toInt() ?: 0
    }

    override suspend fun getOrganizerServiceOptions(optionsId: String): OrganizerServiceOptions? {
        logger.info("Fetching organizer service options for id={}", optionsId)
        return client.from("organizer_service_options")
            .select { filter { eq("id", optionsId) } }
            .decodeSingleOrNull<OrganizerServiceOptions>()
    }

    override suspend fun getOrganizerServiceOptionsForVendor(vendorId: String): List<OrganizerServiceOptions> {
        logger.info("Fetching organizer service options for vendorId={}", vendorId)
        return client.from("organizer_service_options")
            .select { filter { eq("vendor_id", vendorId) } }
            .decodeList<OrganizerServiceOptions>()
    }
}
