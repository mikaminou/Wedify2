package com.wedify.vendors.application.usecases

import com.wedify.config.ApiResponse
import com.wedify.vendors.application.validation.validateBusinessDataRequest
import com.wedify.vendors.domain.interfaces.BusinessesOperations
import com.wedify.vendors.domain.schemas.BusinessDataRequest

class CreateNewBusinessUsecase(
    val businessesOperations: BusinessesOperations
) {
    suspend operator fun invoke(data: BusinessDataRequest): ApiResponse {
        return try {
            if (!validateBusinessDataRequest(data)) {
                ApiResponse(400, "Invalid business data")
            } else if (businessesOperations.exists(data)) {
                ApiResponse(409, "Business already exists")
            } else {
                businessesOperations.createBusiness(data)
                ApiResponse(201, "Business created successfully")
            }
        } catch (e: Exception) {
            ApiResponse(500, "Internal server error")
        }
    }
}
