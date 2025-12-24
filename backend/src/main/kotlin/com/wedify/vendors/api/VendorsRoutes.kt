package com.wedify.vendors.api

import com.wedify.vendors.application.usecases.CreateNewBusinessUsecase
import com.wedify.vendors.domain.schemas.BusinessDataRequest
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import org.koin.ktor.ext.inject

fun Route.vendorsRoutes() {
    val createNewBusinessUsecase by inject<CreateNewBusinessUsecase>()

    route("/vendors") {
        post("/businesses") {
            val request = call.receive<BusinessDataRequest>()
            val response = createNewBusinessUsecase(request)
            call.respond(response)
        }
    }
}
