package com.wedify.domain.interfaces

import com.wedify.domain.models.VendorsRestDays

interface VendorsRestDaysOperations {
    suspend fun createVendorRestDay(vendorRestDays: VendorsRestDays): VendorsRestDays
    suspend fun removeVendorRestDay(vendorRestDayId: String): VendorsRestDays?
    suspend fun removeVendorRestDays(vendorId: String): Int
    suspend fun getVendorRestDays(vendorId: String): List<VendorsRestDays>
}
