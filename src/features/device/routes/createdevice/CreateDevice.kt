package com.neci.features.device.routes.createdevice

import com.neci.features.device.data.DeviceData
import com.neci.features.device.model.DeviceRequestDto
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.createDevice() {
    val deviceData: DeviceData by inject(DeviceData::class.java)
    post("/api/v1/device/create_device") {
        // receive request from user
        val request = call.receive<DeviceRequestDto>()
        call.respond(deviceData.createDeviceData(request))
    }
}