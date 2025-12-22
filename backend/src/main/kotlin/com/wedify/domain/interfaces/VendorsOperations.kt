package com.wedify.domain.interfaces

import com.wedify.domain.models.Vendors

interface VendorsOperations {
    suspend fun createVendor(vendor: Vendors): Vendors
    suspend fun updateVendor(vendor: Vendors): Vendors
    suspend fun deleteVendor(vendor: Vendors): Vendors
    suspend fun getVendor(vendorId: String): Vendors?
}
