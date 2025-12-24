package com.wedify.vendors.domain.interfaces.niches

import com.wedify.vendors.domain.models.niches.OrganizerServiceOptions

interface OrganizerServiceOptionsOperations {
    suspend fun createOrganizerServiceOptions(options: OrganizerServiceOptions): OrganizerServiceOptions
    suspend fun updateOrganizerServiceOptions(optionsId: String, options: OrganizerServiceOptions): OrganizerServiceOptions?
    suspend fun deleteOrganizerServiceOptions(optionsId: String): OrganizerServiceOptions?
    suspend fun deleteOrganizerServiceOptionsForVendor(vendorId: String): Int
    suspend fun getOrganizerServiceOptions(optionsId: String): OrganizerServiceOptions?
    suspend fun getOrganizerServiceOptionsForVendor(vendorId: String): List<OrganizerServiceOptions>
}
