package com.wedify.domain.models.niches

import kotlinx.serialization.Serializable

@Serializable
data class MusicServiceOptionsDz(
    val vendorId: String,
    val malouf: Boolean,
    val gasba: Boolean,
    val fkairat: Boolean,
    val band: Boolean,
    val dj: Boolean,
    val soloArtist: Boolean,
    val other: String?,
    val id: String?,
)
