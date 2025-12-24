package com.wedify.vendors.infrastructure.services

import com.wedify.vendors.domain.interfaces.BusinessesOperations
import com.wedify.vendors.domain.models.BusinessData
import com.wedify.config.supabase.SupabaseClientProvider
import org.slf4j.LoggerFactory

class BusinessesService(
    private val supabaseClientProvider: SupabaseClientProvider,
): BusinessesOperations {

    private val logger = LoggerFactory.getLogger(BusinessesService::class.java)

    override suspend fun createBusiness(businessData: BusinessData) {
        TODO("Not yet implemented")
    }
}
