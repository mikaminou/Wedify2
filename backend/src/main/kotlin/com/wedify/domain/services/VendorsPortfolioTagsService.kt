package com.wedify.domain.services

import com.wedify.domain.interfaces.VendorsPortfolioTagsOperations
import com.wedify.domain.models.VendorsPortfolioTags
import com.wedify.infrastructure.supabase.SupabaseClientProvider
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import org.slf4j.LoggerFactory

class VendorsPortfolioTagsService(
    private val supabaseClient: SupabaseClientProvider,
): VendorsPortfolioTagsOperations {

    private val client: SupabaseClient
        get() = supabaseClient.client

    private val logger = LoggerFactory.getLogger(VendorsPortfolioTagsService::class.java)

    override suspend fun tagVendorPortfolio(tag: VendorsPortfolioTags): VendorsPortfolioTags {
        logger.info("Tagging vendor portfolio: $tag")
        return client.from("vendors_portfolio_tags").insert(tag) {
            select()
        }.decodeSingle<VendorsPortfolioTags>()
    }

    override suspend fun untagVendorPortfolio(tagId: String): VendorsPortfolioTags? {
        logger.info("Untagging vendor portfolio tagId: $tagId")
        return client.from("vendors_portfolio_tags").delete {
            select()
            filter {
                eq("id", tagId)
            }
        }.decodeSingleOrNull<VendorsPortfolioTags>()
    }

    override suspend fun deleteTagsForVendor(vendorId: String): Int {
        logger.info("Deleting tags for vendor: $vendorId")
        val response = client.from("vendors_portfolio_tags").delete {
            filter {
                eq("vendor_id", vendorId)
            }
        }
        val deletedCount = response.countOrNull()?.toInt() ?: 0
        return deletedCount
    }

    override suspend fun getTaggedVendorForFile(fileId: String): List<VendorsPortfolioTags> {
        logger.info("Fetching tagged vendor portfolios for fileId= $fileId")
        return client.from("vendors_portfolio_tags")
            .select {
                filter {
                    eq("file_id", fileId)
                }
            }
            .decodeList<VendorsPortfolioTags>()
    }
}
