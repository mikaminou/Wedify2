package com.wedify.vendors.domain.models.niches

import kotlinx.serialization.Serializable

@Serializable
data class OrganizerServiceOptions(
    val vendorId: String,
    val caffeService: Boolean,
    val noCamera: Boolean,
    val organizer: Boolean,
    val id: String?,
)
