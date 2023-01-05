package com.neci.features.authentication.routes

import com.neci.features.authentication.routes.createUser.createUser
import com.neci.features.authentication.routes.deleteUser.deleteUser
import com.neci.features.authentication.routes.loginUser.loginUser
import com.neci.features.authentication.routes.updateUser.updateUser
import com.neci.features.authentication.routes.userInfo.userInfo
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*

fun Application.authenticationRoutes() {
    routing {
        loginUser()
        authenticate {
            userInfo()
            updateUser()
            deleteUser()
        }
        createUser()
    }
}