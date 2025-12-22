package com.wedify.domain.services

import com.wedify.domain.interfaces.BusinessesOperations
import com.wedify.domain.models.BusinessData
import com.wedify.infrastructure.supabase.SupabaseClientProvider
import org.slf4j.LoggerFactory

class BusinessesService(
    private val supabaseClientProvider: SupabaseClientProvider,
): BusinessesOperations {

    private val logger = LoggerFactory.getLogger(BusinessesService::class.java)

    override suspend fun createBusiness(businessData: BusinessData) {
        TODO("Not yet implemented")
    }
}
