package com.wedify.vendors.infrastructure.services

import com.wedify.vendors.domain.interfaces.VendorsOperations
import com.wedify.vendors.domain.models.Vendors
import com.wedify.config.supabase.SupabaseClientProvider
import io.github.jan.supabase.postgrest.from
import org.slf4j.LoggerFactory

class VendorsService(
    private val supabaseClientProvider: SupabaseClientProvider,
): VendorsOperations {

    private val client
        get() = supabaseClientProvider.client

    private val logger = LoggerFactory.getLogger(VendorsService::class.java)

    override suspend fun createVendor(vendor: Vendors): Vendors {
        logger.info("Creating vendor $vendor")
        return client.from("vendors").insert(vendor) {
            select()
        }.decodeSingle<Vendors>()
    }

    override suspend fun updateVendor(vendor: Vendors): Vendors {
        logger.info("Updating vendor $vendor")

        return try {
            val vendorId = vendor.id ?: throw IllegalArgumentException("Vendor ID cannot be null for update operation")
            val updated = client.from("vendors").update(vendor) {
                select()
                filter {
                    eq("id", vendorId)
                }
            }.decodeSingleOrNull<Vendors>()

            updated ?: throw NoSuchElementException("Vendor with id=$vendorId not found")
        } catch (e: Exception) {
            logger.error("Error updating vendor: $vendor", e)
            throw RuntimeException(e.message ?: "Internal server error", e)
        }
    }

    override suspend fun deleteVendor(vendor: Vendors): Vendors {
        logger.info("Deleting vendor $vendor")

        return try {
            val vendorId = vendor.id ?: throw IllegalArgumentException("Vendor ID cannot be null for delete operation")

            val deleted = client.from("vendors").delete {
                select()
                filter {
                    eq("id", vendorId)
                }
            }.decodeSingleOrNull<Vendors>()

            deleted ?: throw NoSuchElementException("Vendor with id=$vendorId not found")
        } catch (e: Exception) {
            logger.error("Error deleting vendor: $vendor", e)
            throw RuntimeException(e.message ?: "Internal server error", e)
        }
    }

    override suspend fun getVendor(vendorId: String): Vendors? {
        logger.info("Fetching vendor for id={}", vendorId)
        return client.from("vendors")
            .select {
                filter {
                    eq("id", vendorId)
                }
            }
            .decodeSingleOrNull<Vendors>()
    }
}
