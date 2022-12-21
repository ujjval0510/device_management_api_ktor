package com.neci.features.device.data

import com.neci.features.device.dao.DeviceDao
import com.neci.features.device.model.DeviceInfoDao
import com.neci.features.device.model.DeviceRequestDto

class DeviceDataImpl(private val deviceDao: DeviceDao) : DeviceData {
    override suspend fun createDeviceData(requestDto: DeviceRequestDto): DeviceInfoDao {
        return deviceDao.createDevice(requestDto)
    }

    override suspend fun getAllDeviceList(): List<DeviceInfoDao> {
        return deviceDao.getDeviceList()
    }

//    override suspend fun getDeviceInfo(deviceId: Int): DeviceInfoDto {
//        return deviceDao.getDeviceInfo(deviceId = deviceId)
//    }
}