package com.neci.features.device.data
import com.neci.features.device.model.DeviceInfoDao
import com.neci.features.device.model.DeviceRequestDto

interface DeviceData {
    suspend fun createDeviceData(requestDto: DeviceRequestDto): DeviceInfoDao
    suspend fun getAllDeviceList(): List<DeviceInfoDao>
//    suspend fun getDeviceInfo(deviceId: Int): DeviceInfoDto
}