package com.wedify.vendors.domain.interfaces.niches

import com.wedify.vendors.domain.models.niches.VenueServiceOptions

interface VenueServiceOptionsOperations {
    suspend fun createVenueServiceOptions(options: VenueServiceOptions): VenueServiceOptions
    suspend fun updateVenueServiceOptions(optionsId: String, options: VenueServiceOptions): VenueServiceOptions?
    suspend fun deleteVenueServiceOptions(optionsId: String): VenueServiceOptions?
    suspend fun deleteVenueServiceOptionsForVendor(vendorId: String): Int
    suspend fun getVenueServiceOptions(optionsId: String): VenueServiceOptions?
    suspend fun getVenueServiceOptionsForVendor(vendorId: String): List<VenueServiceOptions>
}
