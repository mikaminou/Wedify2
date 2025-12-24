package com.wedify.vendors.api

import com.wedify.config.ApiResponse
import com.wedify.vendors.application.usecases.CreateNewBusinessUseCase
import com.wedify.vendors.application.usecases.RolloutBusinessUseCase
import com.wedify.vendors.domain.schemas.BusinessDataRequest
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import org.koin.ktor.ext.inject
import java.nio.file.Files.delete
import kotlin.text.get

fun Route.vendorsRoutes() {
    val createNewBusinessUsecase by inject<CreateNewBusinessUseCase>()
    val rolloutBusinessUseCase by inject<RolloutBusinessUseCase>()
    route("/vendors") {
        post("/businesses") {
            val request = call.receive<BusinessDataRequest>()
            val response = createNewBusinessUsecase(request)
            call.respond(HttpStatusCode.fromValue(response.statusCode), response.message)
        }
        delete("/businesses/{id}") {
            val id = call.parameters["id"] ?: return@delete call.respond(
                ApiResponse(400, "Missing or malformed id")
            )
            val response = rolloutBusinessUseCase(id)
            call.respond(HttpStatusCode.fromValue(response.statusCode), response.message)
        }
    }
}
