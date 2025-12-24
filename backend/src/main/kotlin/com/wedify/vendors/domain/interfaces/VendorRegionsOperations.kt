package com.wedify.vendors.domain.interfaces

import com.wedify.vendors.domain.models.VendorRegions

interface VendorRegionsOperations {
    suspend fun addVendorRegion(vendorRegion: VendorRegions): VendorRegions
    suspend fun removeVendorRegion(vendorRegionId: String): VendorRegions?
    suspend fun removeVendorRegions(vendorId: String): Int
    suspend fun getVendorRegions(vendorId: String): List<VendorRegions>
}
