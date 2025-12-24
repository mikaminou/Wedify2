package com.wedify.vendors.domain.interfaces.niches

import com.wedify.vendors.domain.models.niches.TransportationServiceOptions

interface TransportationServiceOptionsOperations {
    suspend fun createTransportationServiceOptions(options: TransportationServiceOptions): TransportationServiceOptions
    suspend fun updateTransportationServiceOptions(optionsId: String, options: TransportationServiceOptions): TransportationServiceOptions?
    suspend fun deleteTransportationServiceOptions(optionsId: String): TransportationServiceOptions?
    suspend fun deleteTransportationServiceOptionsForVendor(vendorId: String): Int
    suspend fun getTransportationServiceOptions(optionsId: String): TransportationServiceOptions?
    suspend fun getTransportationServiceOptionsForVendor(vendorId: String): List<TransportationServiceOptions>
}
