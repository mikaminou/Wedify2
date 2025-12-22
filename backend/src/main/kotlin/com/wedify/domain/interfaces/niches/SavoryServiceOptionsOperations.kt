package com.wedify.domain.interfaces.niches

import com.wedify.domain.models.niches.SavoryServiceOptions

interface SavoryServiceOptionsOperations {
    suspend fun createSavoryServiceOptions(options: SavoryServiceOptions): SavoryServiceOptions
    suspend fun updateSavoryServiceOptions(optionsId: String, options: SavoryServiceOptions): SavoryServiceOptions?
    suspend fun deleteSavoryServiceOptions(optionsId: String): SavoryServiceOptions?
    suspend fun deleteSavoryServiceOptionsForVendor(vendorId: String): Int
    suspend fun getSavoryServiceOptions(optionsId: String): SavoryServiceOptions?
    suspend fun getSavoryServiceOptionsForVendor(vendorId: String): List<SavoryServiceOptions>
}
