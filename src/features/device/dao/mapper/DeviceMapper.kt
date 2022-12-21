package com.neci.features.device.dao.mapper
import com.neci.features.device.model.DeviceInfoDao
import org.jetbrains.exposed.sql.ResultRow

interface DeviceMapper {
    //    fun fromDeviceDaoToDeviceInfo(resultRow: ResultRow): DeviceInfoDto
    fun fromDeviceDaoToDeviceList(resultRow: List<ResultRow>): List<DeviceInfoDao>

}