package com.neci.features.device.routes.getdeviceinfo

import com.neci.features.device.data.DeviceData
import com.neci.features.device.model.UpdateDeviceRequestDto
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.getDevicesInfo() {
    val deviceData: DeviceData by inject(DeviceData::class.java)
    get("/api/v1/device/get_device_info/{id}") {
        call.respond(deviceData.getDeviceInfo(deviceId =  call.parameters["id"]!!.toInt()));
    }
}