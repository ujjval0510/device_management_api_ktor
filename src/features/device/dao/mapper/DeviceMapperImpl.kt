package com.neci.features.device.dao.mapper

import com.neci.features.authentication.dao.entity.UserTable
import com.neci.features.authentication.model.UserInfoDto
import com.neci.features.device.dao.entity.DeviceMasterTable
import com.neci.features.device.model.DeviceInfoDao
import org.jetbrains.exposed.sql.ResultRow

class DeviceMapperImpl : DeviceMapper {
    // get single device data
    override fun fromDeviceDaoToDeviceInfo(resultRow: ResultRow) = DeviceInfoDao(
        id = resultRow[DeviceMasterTable.id],
        name = resultRow[DeviceMasterTable.name],
        os = resultRow[DeviceMasterTable.os],
        isDeleted = resultRow[DeviceMasterTable.is_deleted],
        osVersion = resultRow[DeviceMasterTable.os_version],
        deviceNumber = resultRow[DeviceMasterTable.device_number],
        createdAt = resultRow[DeviceMasterTable.created_at],
        updatedAt = resultRow[DeviceMasterTable.updated_at],
    )

    // Get all device list
    override fun fromDeviceDaoToDeviceList(resultRow: List<ResultRow>): List<DeviceInfoDao> {
        return resultRow.map { DeviceInfoDao.fromRow(it) }
    }


}