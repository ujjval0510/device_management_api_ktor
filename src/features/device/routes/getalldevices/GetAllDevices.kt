package com.neci.features.device.routes.getalldevices

import com.neci.features.device.data.DeviceData
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.getAllDevices() {
    val deviceData: DeviceData by inject(DeviceData::class.java)
    get("/api/v1/device/get-devices") {
        call.respond(deviceData.getAllDeviceList())
    }
}