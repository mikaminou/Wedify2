package com.wedify.vendors.infrastructure.services

import com.wedify.vendors.domain.interfaces.BusinessesOperations
import com.wedify.vendors.domain.schemas.BusinessDataRequest
import org.slf4j.LoggerFactory

class BusinessesService(
    private val vendorsService: VendorsService,
    private val vendorRegionsService: VendorRegionsService,
    private val vendorPackagesService: VendorPackagesService,
    private val vendorPromotionsService: VendorPromotionsService,
    private val vendorsRestDaysService: VendorsRestDaysService,
    private val vendorsPortfolioTagsService: VendorsPortfolioTagsService,
): BusinessesOperations {

    private val logger = LoggerFactory.getLogger(BusinessesService::class.java)

    override suspend fun createBusiness(businessData: BusinessDataRequest) {
        logger.info("Creating business with data: $businessData")
        var vendorId: String? = null
        try {
            val vendor = vendorsService.createVendor(businessData.basicInfo)
            vendorId = vendor.id

            val regions = vendorRegionsService.addVendorRegionsBatch(businessData.regions)
            if (businessData.regions.isNotEmpty() && regions.isEmpty()) throw Exception("Failed to add vendor regions")

            val packages = vendorPackagesService.createVendorPackagesBatch(businessData.packages)
            if (businessData.packages.isNotEmpty() && packages.isEmpty()) throw Exception("Failed to add vendor packages")

            val restDays = vendorsRestDaysService.createVendorRestDaysBatch(businessData.restDays)
            if (businessData.restDays.isNotEmpty() && restDays.isEmpty()) throw Exception("Failed to add vendor rest days")

            val promotions = vendorPromotionsService.createVendorPromotionsBatch(businessData.promotions)
            if (businessData.promotions.isNotEmpty() && promotions.isEmpty()) throw Exception("Failed to add vendor promotions")

            val portfolioTags = vendorsPortfolioTagsService.tagVendorPortfoliosBatch(businessData.portfolioTags.orEmpty())
            if (businessData.portfolioTags?.isNotEmpty() == true && portfolioTags.isEmpty()) throw Exception("Failed to add vendor portfolio tags")

            logger.info("Business created successfully with vendorId=${vendor.id}")
        } catch (e: Exception) {
            logger.error("Error creating business: $businessData", e)
            if (vendorId != null) rolloutBusiness(vendorId)
            throw RuntimeException("Failed to create business", e)
        }
    }

    override suspend fun rolloutBusiness(vendorId: String) {
        logger.info("Rolling out business with ID: $vendorId")
        logger.info("Step1: Rolling out vendor rest days for business ID: $vendorId")
        vendorsRestDaysService.removeVendorRestDays(vendorId)
        logger.info("Step2: Rolling out vendor promotions for business ID: $vendorId")
        vendorPromotionsService.deleteVendorPromotions(vendorId)
        logger.info("Step3: Rolling out vendor packages for business ID: $vendorId")
        vendorPackagesService.deleteVendorPackages(vendorId)
        logger.info("Step4: Rolling out vendor regions for business ID: $vendorId")
        vendorRegionsService.removeVendorRegions(vendorId)
        logger.info("Step5: Rolling out vendor tags for business ID: $vendorId")
        vendorsService.deleteVendor(vendorId)
        logger.info("Step6: Rolling out vendor for business ID: $vendorId")
        vendorsPortfolioTagsService.deleteTagsForVendor(vendorId)
        logger.info("Business with ID: $vendorId rolled out successfully")
    }

    override suspend fun exists(businessData: BusinessDataRequest): Boolean {
        val userId = businessData.basicInfo.userId
        val businessName = businessData.basicInfo.businessName
        val existing = vendorsService.getVendorByUserIdAndBusinessName(userId, businessName)
        return existing != null
    }
}
