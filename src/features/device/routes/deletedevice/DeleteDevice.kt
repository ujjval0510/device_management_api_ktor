package com.neci.features.device.routes.createdevice

import com.neci.features.device.data.DeviceData
import com.neci.features.device.model.DeviceRequestDto
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.deleteDevice() {
    val deviceData: DeviceData by inject(DeviceData::class.java)
    put("/api/v1/device/delete_device/{id}") {
        call.respond(deviceData.deleteDeviceData(deviceId =  call.parameters["id"]!!.toInt()))
    }
}