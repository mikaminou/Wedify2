package com.wedify.domain.interfaces

import com.wedify.domain.models.BusinessData

interface BusinessesOperations {
    suspend fun createBusiness(businessData: BusinessData)
}
