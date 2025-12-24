package com.wedify.vendors.domain.interfaces.niches

import com.wedify.vendors.domain.models.niches.ClothingServiceOptionsDz

interface ClothingServiceOptionsDzOperations {
    suspend fun createClothingServiceOptionsDz(options: ClothingServiceOptionsDz): ClothingServiceOptionsDz
    suspend fun updateClothingServiceOptionsDz(optionsId: String, options: ClothingServiceOptionsDz): ClothingServiceOptionsDz?
    suspend fun deleteClothingServiceOptionsDz(optionsId: String): ClothingServiceOptionsDz?
    suspend fun deleteClothingServiceOptionsDzForVendor(vendorId: String): Int
    suspend fun getClothingServiceOptionsDz(optionsId: String): ClothingServiceOptionsDz?
    suspend fun getClothingServiceOptionsDzForVendor(vendorId: String): List<ClothingServiceOptionsDz>
}
