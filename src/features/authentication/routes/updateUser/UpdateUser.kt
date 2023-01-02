package com.neci.features.authentication.routes.updateUser

import com.neci.features.authentication.data.AuthenticationData
import com.neci.features.authentication.model.UpdateUserInfoDto
import com.neci.features.authentication.model.UserInfoDto
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.updateUser() {
    val authenticationData: AuthenticationData by inject(AuthenticationData::class.java)
    post("/public-api/v1/authentication/updateUser") {
        call.respond(authenticationData.updateUser(call.receive<UpdateUserInfoDto>()))
    }
}