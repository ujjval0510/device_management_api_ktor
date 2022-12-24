package com.neci.features.device.model

import com.neci.features.device.dao.entity.DeviceMasterTable
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow

data class DeviceInfoDao(
    val id: Int,
    val name: String,
    val os: String? = null,
    val osVersion: String? = null,
    val isDeleted: Int? = 0,
    val deviceNumber: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
) {
    companion object {
        fun fromRow(resultRow: ResultRow) = DeviceInfoDao(
            id = resultRow[DeviceMasterTable.id],
            name = resultRow[DeviceMasterTable.name],
            os = resultRow[DeviceMasterTable.os],
            osVersion = resultRow[DeviceMasterTable.os_version],
            isDeleted = resultRow[DeviceMasterTable.is_deleted],
            deviceNumber = resultRow[DeviceMasterTable.device_number],
            createdAt = resultRow[DeviceMasterTable.created_at].toString(),
            updatedAt = resultRow[DeviceMasterTable.updated_at].toString(),
        )
    }
}