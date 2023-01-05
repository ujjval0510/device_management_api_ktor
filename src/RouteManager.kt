package com.neci

import com.neci.features.authentication.routes.authenticationRoutes
import com.neci.features.device.routes.deviceDataModule
import io.ktor.server.application.*

fun Application.routes() {
    authenticationRoutes()
    deviceDataModule()
}