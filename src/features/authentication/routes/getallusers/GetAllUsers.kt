package com.neci.features.authentication.routes.getallusers

import com.neci.features.authentication.data.AuthenticationData
import com.neci.features.authentication.model.UserInfoDao
import com.neci.features.authentication.model.UserInfoDto
import com.neci.features.device.data.DeviceData
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.getAllUsers() {
    val userData: AuthenticationData by inject(AuthenticationData::class.java)
    get("/api/v1/user/get-user-list") {
        call.respond(userData.getAllUserList())
    }
}