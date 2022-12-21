package com.neci.features.device.dao

import com.neci.features.device.model.DeviceInfoDao
import com.neci.features.device.model.DeviceRequestDto

interface DeviceDao {
    fun getDeviceList(): List<DeviceInfoDao>
    fun createDevice(requestDto: DeviceRequestDto): DeviceInfoDao
//    fun getDeviceInfo(deviceId: Int): DeviceInfoDto
}