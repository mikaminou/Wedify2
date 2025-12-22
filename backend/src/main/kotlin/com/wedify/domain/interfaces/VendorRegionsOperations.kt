package com.wedify.domain.interfaces

import com.wedify.domain.models.VendorRegions

interface VendorRegionsOperations {
    suspend fun addVendorRegion(vendorRegion: VendorRegions): VendorRegions
    suspend fun removeVendorRegion(vendorRegionId: String): VendorRegions?
    suspend fun removeVendorRegions(vendorId: String): Int
    suspend fun getVendorRegions(vendorId: String): List<VendorRegions>
}
