package com.wedify.domain.interfaces.niches

import com.wedify.domain.models.niches.BeautyServiceOptions

interface BeautyServiceOptionsOperations {
    suspend fun createBeautyServiceOptions(options: BeautyServiceOptions): BeautyServiceOptions
    suspend fun updateBeautyServiceOptions(optionsId: String, options: BeautyServiceOptions): BeautyServiceOptions?
    suspend fun deleteBeautyServiceOptions(optionsId: String): BeautyServiceOptions?
    suspend fun deleteBeautyServiceOptionsForVendor(vendorId: String): Int
    suspend fun getBeautyServiceOptions(optionsId: String): BeautyServiceOptions?
    suspend fun getBeautyServiceOptionsForVendor(vendorId: String): List<BeautyServiceOptions>
}
