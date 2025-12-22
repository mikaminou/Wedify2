package com.wedify.domain.services

import com.wedify.domain.interfaces.VendorPackagesOperations
import com.wedify.domain.models.VendorPackages
import com.wedify.infrastructure.supabase.SupabaseClientProvider
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.slf4j.LoggerFactory

class VendorPackagesService(
    private val supabaseClientProvider: SupabaseClientProvider,
): VendorPackagesOperations {

    private val client : SupabaseClient
        get() = supabaseClientProvider.client

    private val logger = LoggerFactory.getLogger(VendorPackagesService::class.java)

    override suspend fun createVendorPackage(pack: VendorPackages): VendorPackages {
        logger.info("Creating vendor package: $pack")
        return client.from("vendor_packages").insert(pack) {
            select()
        }.decodeSingle<VendorPackages>()
    }

    override suspend fun deleteVendorPackage(vendorPackageId: String): VendorPackages? {
        logger.info("Deleting vendor package: $vendorPackageId")
        return client.from("cities").delete {
            select()
            filter {
                eq("id", vendorPackageId)
            }
        }.decodeSingleOrNull<VendorPackages>()
    }

    override suspend fun deleteVendorPackages(vendorId: String): Int {
        logger.info("Deleting vendor packages for vendor: $vendorId")
        val response = client.from("vendor_packages").delete {
            filter {
                eq("vendor_id", vendorId)
            }
        }
        val deletedCount = response.countOrNull()?.toInt() ?: 0
        return deletedCount
    }

    override suspend fun getVendorPackages(vendorId: String): List<VendorPackages> {
        logger.info("Fetching vendor packages for vendorId={}", vendorId)
        return client.from("vendor_packages")
            .select{
                filter {
                    eq("vendor_id", vendorId)
                }
            }
            .decodeList<VendorPackages>()
    }

    override suspend fun getVendorPackage(vendorPackageId: String): VendorPackages? {
        logger.info("Fetching vendor package for id={}", vendorPackageId)
        return client.from("vendor_packages")
            .select {
                filter {
                    eq("id", vendorPackageId)
                }
            }
            .decodeSingleOrNull<VendorPackages>()
    }

    override suspend fun updateVendorPackage(
        vendorPackageId: String,
        pack: VendorPackages
    ): VendorPackages? {
        logger.info("Updating vendor package: $vendorPackageId with data: $pack")
        return client.from("vendor_packages").update(pack) {
            select()
            filter {
                eq("id", vendorPackageId)
            }
        }.decodeSingleOrNull<VendorPackages>()
    }
}
