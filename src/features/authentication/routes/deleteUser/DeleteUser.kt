package com.neci.features.authentication.routes.deleteUser

import com.neci.features.authentication.data.AuthenticationData
import com.neci.features.authentication.model.UpdateUserInfoDto
import com.neci.features.authentication.model.UserInfoDto
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.deleteUser() {
    val authenticationData: AuthenticationData by inject(AuthenticationData::class.java)
    put("/public-api/v1/authentication/deleteUser/{id}") {
        call.respond(authenticationData.deleteUser(call.parameters["id"]!!.toInt()))
    }
}