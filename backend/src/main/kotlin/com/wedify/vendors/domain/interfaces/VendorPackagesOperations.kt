package com.wedify.vendors.domain.interfaces

import com.wedify.vendors.domain.models.VendorPackages

interface VendorPackagesOperations {
    suspend fun createVendorPackage(pack: VendorPackages): VendorPackages
    suspend fun deleteVendorPackage(vendorPackageId: String): VendorPackages?
    suspend fun deleteVendorPackages(vendorId: String): Int
    suspend fun getVendorPackages(vendorId: String): List<VendorPackages>
    suspend fun getVendorPackage(vendorPackageId: String): VendorPackages?
    suspend fun updateVendorPackage(vendorPackageId: String, pack: VendorPackages): VendorPackages?
}
