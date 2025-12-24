package com.wedify.vendors.domain.interfaces.niches

import com.wedify.vendors.domain.models.niches.MusicServiceOptionsDz

interface MusicServiceOptionsDzOperations {
    suspend fun createMusicServiceOptionsDz(options: MusicServiceOptionsDz): MusicServiceOptionsDz
    suspend fun updateMusicServiceOptionsDz(optionsId: String, options: MusicServiceOptionsDz): MusicServiceOptionsDz?
    suspend fun deleteMusicServiceOptionsDz(optionsId: String): MusicServiceOptionsDz?
    suspend fun deleteMusicServiceOptionsDzForVendor(vendorId: String): Int
    suspend fun getMusicServiceOptionsDz(optionsId: String): MusicServiceOptionsDz?
    suspend fun getMusicServiceOptionsDzForVendor(vendorId: String): List<MusicServiceOptionsDz>
}
