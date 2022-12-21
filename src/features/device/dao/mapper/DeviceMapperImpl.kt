package com.neci.features.device.dao.mapper

import com.neci.features.device.model.DeviceInfoDao
import org.jetbrains.exposed.sql.ResultRow

class DeviceMapperImpl : DeviceMapper {
    // Get all device list
    override fun fromDeviceDaoToDeviceList(resultRow: List<ResultRow>): List<DeviceInfoDao> {
        return resultRow.map { DeviceInfoDao.fromRow(it) }
    }


}