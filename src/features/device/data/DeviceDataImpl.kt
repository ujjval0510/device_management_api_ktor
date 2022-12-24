package com.neci.features.device.data

import com.neci.features.device.dao.DeviceDao
import com.neci.features.device.model.DeviceInfoDao
import com.neci.features.device.model.DeviceRequestDto
import com.neci.features.device.model.UpdateDeviceRequestDto

class DeviceDataImpl(private val deviceDao: DeviceDao) : DeviceData {
    override suspend fun createDeviceData(requestDto: DeviceRequestDto): DeviceInfoDao {
        return deviceDao.createDevice(requestDto)
    }

    override suspend fun getAllDeviceList(): List<DeviceInfoDao> {
        return deviceDao.getDeviceList()
    }

    override suspend fun updateDeviceData(requestDto: UpdateDeviceRequestDto): DeviceInfoDao {
        return deviceDao.updateDevice(requestDto);
    }

//    override suspend fun getDeviceInfo(deviceId: Int): DeviceInfoDto {
//        return deviceDao.getDeviceInfo(deviceId = deviceId)
//    }
}