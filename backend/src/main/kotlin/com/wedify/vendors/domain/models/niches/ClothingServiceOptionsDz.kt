package com.wedify.vendors.domain.models.niches

import kotlinx.serialization.Serializable

@Serializable
data class ClothingServiceOptionsDz(
    val vendorId: String,
    val accessories: Boolean,
    val badroune: Boolean,
    val benouare: Boolean,
    val caftan: Boolean,
    val blouzaWahrani: Boolean,
    val blouzaMansouj: Boolean,
    val chedda: Boolean,
    val gandoura: Boolean,
    val eveningDress: Boolean,
    val ghelila: Boolean,
    val karakou: Boolean,
    val katifaFergani: Boolean,
    val leffa: Boolean,
    val naili: Boolean,
    val weddingDress: Boolean,
    val barnous: Boolean,
    val suit: Boolean,
    val tuxedo: Boolean,
    val other: String?,
    val id: String?,
)
