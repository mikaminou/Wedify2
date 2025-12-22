package com.wedify.domain.models.niches

import kotlinx.serialization.Serializable

@Serializable
data class TransportationServiceOptions(
    val vendorId: String,
    val hasLimousines: Boolean,
    val hasSportCars: Boolean,
    val hasSuvCars: Boolean,
    val hasMotorbikes: Boolean,
    val id: String?,
)
