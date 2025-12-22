package com.wedify.domain.models.niches

import kotlinx.serialization.Serializable

@Serializable
data class VenueServiceOptions(
    val vendorId: String,
    val maxGuests: Int,
    val decorated: Boolean,
    val minGuests: Int?,
    val hasParkingSpace: Boolean?,
    val parkingSlots: Int?,
    val id: String?,
)
