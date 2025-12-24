package com.wedify.vendors.domain.interfaces

import com.wedify.vendors.domain.schemas.BusinessDataRequest

interface BusinessesOperations {
    suspend fun createBusiness(businessData: BusinessDataRequest)
    suspend fun rolloutBusiness(vendorId: String): Boolean
    suspend fun exists(businessData: BusinessDataRequest): Boolean
}
