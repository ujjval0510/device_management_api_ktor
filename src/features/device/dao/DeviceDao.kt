package com.neci.features.device.dao

import com.neci.features.device.model.DeviceInfoDao
import com.neci.features.device.model.DeviceRequestDto
import com.neci.features.device.model.UpdateDeviceRequestDto

interface DeviceDao {
    fun getDeviceList(): List<DeviceInfoDao>
    fun createDevice(requestDto: DeviceRequestDto): DeviceInfoDao
    fun updateDevice(requestDto: UpdateDeviceRequestDto): DeviceInfoDao
//    fun getDeviceInfo(deviceId: Int): DeviceInfoDto
}