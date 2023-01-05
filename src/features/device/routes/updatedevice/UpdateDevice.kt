package com.neci.features.device.routes.updatedevice

import com.neci.features.device.data.DeviceData
import com.neci.features.device.model.DeviceRequestDto
import com.neci.features.device.model.UpdateDeviceRequestDto
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.updateDevice() {
    val deviceData: DeviceData by inject(DeviceData::class.java)
    post("/api/v1/device/update_device") {
        // receive request from user
        val request = call.receive<UpdateDeviceRequestDto>()
        call.respond(deviceData.updateDeviceData(request))
    }
}