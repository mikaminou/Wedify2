package com.wedify.domain.services.niches

import com.wedify.domain.interfaces.niches.MusicServiceOptionsDzOperations
import com.wedify.domain.models.niches.MusicServiceOptionsDz
import com.wedify.infrastructure.supabase.SupabaseClientProvider
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.slf4j.LoggerFactory

class MusicServiceOptionsDzService(
    private val supabaseClientProvider: SupabaseClientProvider,
) : MusicServiceOptionsDzOperations {

    private val client: SupabaseClient
        get() = supabaseClientProvider.client

    private val logger = LoggerFactory.getLogger(MusicServiceOptionsDzService::class.java)

    override suspend fun createMusicServiceOptionsDz(options: MusicServiceOptionsDz): MusicServiceOptionsDz {
        logger.info("Creating music service options dz: $options")
        return client.from("music_service_options_dz").insert(options) {
            select()
        }.decodeSingle<MusicServiceOptionsDz>()
    }

    override suspend fun updateMusicServiceOptionsDz(
        optionsId: String,
        options: MusicServiceOptionsDz
    ): MusicServiceOptionsDz? {
        logger.info("Updating music service options dz: $optionsId with data: $options")
        return client.from("music_service_options_dz").update(options) {
            select()
            filter { eq("id", optionsId) }
        }.decodeSingleOrNull<MusicServiceOptionsDz>()
    }

    override suspend fun deleteMusicServiceOptionsDz(optionsId: String): MusicServiceOptionsDz? {
        logger.info("Deleting music service options dz: $optionsId")
        return client.from("music_service_options_dz").delete {
            select()
            filter { eq("id", optionsId) }
        }.decodeSingleOrNull<MusicServiceOptionsDz>()
    }

    override suspend fun deleteMusicServiceOptionsDzForVendor(vendorId: String): Int {
        logger.info("Deleting music service options dz for vendor: $vendorId")
        val response = client.from("music_service_options_dz").delete {
            filter { eq("vendor_id", vendorId) }
        }
        return response.countOrNull()?.toInt() ?: 0
    }

    override suspend fun getMusicServiceOptionsDz(optionsId: String): MusicServiceOptionsDz? {
        logger.info("Fetching music service options dz for id={}", optionsId)
        return client.from("music_service_options_dz")
            .select { filter { eq("id", optionsId) } }
            .decodeSingleOrNull<MusicServiceOptionsDz>()
    }

    override suspend fun getMusicServiceOptionsDzForVendor(vendorId: String): List<MusicServiceOptionsDz> {
        logger.info("Fetching music service options dz for vendorId={}", vendorId)
        return client.from("music_service_options_dz")
            .select { filter { eq("vendor_id", vendorId) } }
            .decodeList<MusicServiceOptionsDz>()
    }
}
