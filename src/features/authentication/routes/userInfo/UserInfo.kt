package com.neci.features.authentication.routes.userInfo

import com.neci.extensions.getAuthorizationTokenWithoutBearer
import com.neci.features.authentication.data.AuthenticationData
import com.neci.jwt.JwtManager
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.userInfo() {
    val authenticationData: AuthenticationData by inject(AuthenticationData::class.java)
    val jwtManager: JwtManager by inject(JwtManager::class.java)
    get("/api/v1/user/user-info") {
        call.respond(authenticationData.getUserInfo(jwtManager.getUsernameFromToken(call.getAuthorizationTokenWithoutBearer())!!))
    }
}