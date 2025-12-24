package com.wedify.vendors.domain.interfaces

import com.wedify.vendors.domain.models.BusinessData

interface BusinessesOperations {
    suspend fun createBusiness(businessData: BusinessData)
}
