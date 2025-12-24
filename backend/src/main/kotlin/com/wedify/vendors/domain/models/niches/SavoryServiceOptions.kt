package com.wedify.vendors.domain.models.niches

import kotlinx.serialization.Serializable

@Serializable
data class SavoryServiceOptions(
    val vendorId: String,
    val appetizers: Boolean,
    val buffet: Boolean,
    val drinks: Boolean,
    val pastry: Boolean,
    val weddingCake: Boolean,
    val dinner: Boolean,
    val other: String?,
    val id: String?,
)
