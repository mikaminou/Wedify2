package com.wedify.vendors.domain.models.niches

import kotlinx.serialization.Serializable

@Serializable
data class BeautyServiceOptions(
    val vendorId: String,
    val hairString: Boolean,
    val makeup: Boolean,
    val nailServices: Boolean,
    val skinCare: Boolean,
    val other: String?,
    val id: String?,
)
