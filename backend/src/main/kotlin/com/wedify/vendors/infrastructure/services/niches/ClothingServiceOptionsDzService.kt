package com.wedify.vendors.infrastructure.services.niches

import com.wedify.vendors.domain.interfaces.niches.ClothingServiceOptionsDzOperations
import com.wedify.vendors.domain.models.niches.ClothingServiceOptionsDz
import com.wedify.config.supabase.SupabaseClientProvider
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.slf4j.LoggerFactory

class ClothingServiceOptionsDzService(
    private val supabaseClientProvider: SupabaseClientProvider,
) : ClothingServiceOptionsDzOperations {

    private val client: SupabaseClient
        get() = supabaseClientProvider.client

    private val logger = LoggerFactory.getLogger(ClothingServiceOptionsDzService::class.java)

    override suspend fun createClothingServiceOptionsDz(options: ClothingServiceOptionsDz): ClothingServiceOptionsDz {
        logger.info("Creating clothing service options dz: $options")
        return client.from("clothing_service_options_dz").insert(options) {
            select()
        }.decodeSingle<ClothingServiceOptionsDz>()
    }

    override suspend fun updateClothingServiceOptionsDz(
        optionsId: String,
        options: ClothingServiceOptionsDz
    ): ClothingServiceOptionsDz? {
        logger.info("Updating clothing service options dz: $optionsId with data: $options")
        return client.from("clothing_service_options_dz").update(options) {
            select()
            filter { eq("id", optionsId) }
        }.decodeSingleOrNull<ClothingServiceOptionsDz>()
    }

    override suspend fun deleteClothingServiceOptionsDz(optionsId: String): ClothingServiceOptionsDz? {
        logger.info("Deleting clothing service options dz: $optionsId")
        return client.from("clothing_service_options_dz").delete {
            select()
            filter { eq("id", optionsId) }
        }.decodeSingleOrNull<ClothingServiceOptionsDz>()
    }

    override suspend fun deleteClothingServiceOptionsDzForVendor(vendorId: String): Int {
        logger.info("Deleting clothing service options dz for vendor: $vendorId")
        val response = client.from("clothing_service_options_dz").delete {
            filter { eq("vendor_id", vendorId) }
        }
        return response.countOrNull()?.toInt() ?: 0
    }

    override suspend fun getClothingServiceOptionsDz(optionsId: String): ClothingServiceOptionsDz? {
        logger.info("Fetching clothing service options dz for id={}", optionsId)
        return client.from("clothing_service_options_dz")
            .select { filter { eq("id", optionsId) } }
            .decodeSingleOrNull<ClothingServiceOptionsDz>()
    }

    override suspend fun getClothingServiceOptionsDzForVendor(vendorId: String): List<ClothingServiceOptionsDz> {
        logger.info("Fetching clothing service options dz for vendorId={}", vendorId)
        return client.from("clothing_service_options_dz")
            .select { filter { eq("vendor_id", vendorId) } }
            .decodeList<ClothingServiceOptionsDz>()
    }
}
