package com.wedify.vendors.application.usecases

import com.wedify.config.ApiResponse
import com.wedify.vendors.domain.interfaces.BusinessesOperations

class RolloutBusinessUseCase(
    val businessesOperations: BusinessesOperations
) {
    suspend operator fun invoke(businessId: String): ApiResponse {
        return try {
            val result = businessesOperations.rolloutBusiness(businessId)
            if (result) {
                ApiResponse(200, "Business rollout successful")
            } else {
                ApiResponse(404, "Business not found or rollout failed")
            }
        } catch (e: Exception) {
            ApiResponse(500, "Internal server error")
        }
    }
}
