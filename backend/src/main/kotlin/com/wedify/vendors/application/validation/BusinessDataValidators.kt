package com.wedify.vendors.application.validation

import com.wedify.vendors.domain.models.VendorPackages
import com.wedify.vendors.domain.models.VendorPromotions
import com.wedify.vendors.domain.models.VendorRegions
import com.wedify.vendors.domain.models.Vendors
import com.wedify.vendors.domain.models.VendorsRestDays
import com.wedify.vendors.domain.schemas.BusinessDataRequest

fun validateVendors(vendor: Vendors): Boolean =
    vendor.userId.isNotBlank() &&
            vendor.serviceTypeId.isNotBlank() &&
            vendor.businessName.isNotBlank() &&
            vendor.rating?.let { it in 0.0..5.0 } ?: true &&
            vendor.reviewCount?.let { it >= 0 } ?: true

fun validateVendorRegions(regions: List<VendorRegions>): Boolean =
    regions.all { region ->
        region.vendorId.isNotBlank() && region.regionName.lowercase() in validWilayas.map { it.lowercase() }
    }

fun validateVendorPackages(packages: List<VendorPackages>): Boolean =
    packages.all { it.vendorId.isNotBlank() && it.packageName.isNotBlank() && it.price >= 0 }

fun validateVendorPromotions(promotions: List<VendorPromotions>): Boolean =
    promotions.all { it.vendorId.isNotBlank() && it.name.isNotBlank() && it.originalPrice >= 0 && it.discountPrice >= 0 }

fun validateVendorsRestDays(restDays: List<VendorsRestDays>): Boolean =
    restDays.all { it.vendorId.isNotBlank() && it.dayOfWeek.isNotBlank() }

fun validateBusinessDataRequest(request: BusinessDataRequest): Boolean =
    validateVendors(request.basicInfo) &&
            validateVendorRegions(request.regions) &&
            validateVendorPackages(request.packages) &&
            validateVendorPromotions(request.promotions) &&
            validateVendorsRestDays(request.restDays)

private val validWilayas = setOf(
    "Adrar", "Chlef", "Laghouat", "Oum El Bouaghi", "Batna", "Béjaïa", "Biskra", "Béchar", "Blida",
    "Bouïra", "Tamanrasset", "Tébessa", "Tlemcen", "Tiaret", "Tizi Ouzou", "Algiers", "Djelfa", "Jijel",
    "Sétif", "Saïda", "Skikda", "Sidi Bel Abbès", "Annaba", "Guelma", "Constantine", "Médéa", "Mostaganem",
    "M'Sila", "Mascara", "Ouargla", "Oran", "El Bayadh", "Illizi", "Bordj Bou Arréridj", "Boumerdès",
    "El Tarf", "Tindouf", "Tissemsilt", "El Oued", "Khenchela", "Souk Ahras", "Tipaza", "Mila",
    "Aïn Defla", "Naâma", "Aïn Témouchent", "Ghardaïa", "Relizane", "Timimoun", "Bordj Badji Mokhtar",
    "Ouled Djellal", "Béni Abbès", "Ain Salah", "Ain Guezzam", "Touggourt", "Djanet", "El M'Ghair", "El Menia"
)
