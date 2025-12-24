package com.wedify.plugins

import com.wedify.config.AppConfig
import com.wedify.auth.infrastructure.AuthService
import com.wedify.config.supabase.SupabaseClientProvider
import com.wedify.vendors.application.usecases.CreateNewBusinessUseCase
import com.wedify.vendors.application.usecases.RolloutBusinessUseCase
import com.wedify.vendors.domain.interfaces.BusinessesOperations
import com.wedify.vendors.infrastructure.services.BusinessesService
import com.wedify.vendors.infrastructure.services.VendorPackagesService
import com.wedify.vendors.infrastructure.services.VendorPromotionsService
import com.wedify.vendors.infrastructure.services.VendorRegionsService
import com.wedify.vendors.infrastructure.services.VendorsPortfolioTagsService
import com.wedify.vendors.infrastructure.services.VendorsRestDaysService
import com.wedify.vendors.infrastructure.services.VendorsService
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin(appConfig: AppConfig) {
    install(Koin) {
        slf4jLogger()
        modules(appModule(appConfig))
    }
}

fun appModule(appConfig: AppConfig) = module {
    single { appConfig }
    single { SupabaseClientProvider(get()) }
    single { AuthService(get()) }
    single { VendorsService(get()) }
    single { VendorRegionsService(get()) }
    single { VendorPackagesService(get()) }
    single { VendorPromotionsService(get()) }
    single { VendorsRestDaysService(get()) }
    single { VendorsPortfolioTagsService(get()) }
    single { BusinessesService(
        get(),
        get(),
        get(),
        get(),
        get(),
        get()
    ) }
    single<BusinessesOperations> { get<BusinessesService>() }
    single { CreateNewBusinessUseCase(businessesOperations = get()) }
    single { RolloutBusinessUseCase(businessesOperations = get()) }
}
