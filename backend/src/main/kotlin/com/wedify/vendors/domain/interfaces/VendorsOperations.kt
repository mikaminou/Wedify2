package com.wedify.vendors.domain.interfaces

import com.wedify.vendors.domain.models.Vendors

interface VendorsOperations {
    suspend fun createVendor(vendor: Vendors): Vendors
    suspend fun updateVendor(vendor: Vendors): Vendors
    suspend fun deleteVendor(vendor: Vendors): Vendors
    suspend fun getVendor(vendorId: String): Vendors?
}
