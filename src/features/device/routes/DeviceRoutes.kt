package com.neci.features.device.routes

import com.neci.features.device.routes.createdevice.createDevice
import com.neci.features.device.routes.getalldevices.getAllDevices
import com.neci.features.device.routes.updatedevice.updateDevice
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*

fun Application.deviceDataModule() {
    routing {
        authenticate {
            getAllDevices()
            createDevice()
            updateDevice()
        }
    }
}