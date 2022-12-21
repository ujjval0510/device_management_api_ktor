package com.neci.features.device.model

import com.neci.features.device.dao.entity.DeviceMasterTable
import org.jetbrains.exposed.sql.ResultRow

data class DeviceRequestDto(
    val name: String? = null,
    val os: String? = null,
    val osVersion: String? = null,
    val deviceNumber: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
) {
    companion object {
        fun fromRow(resultRow: ResultRow) = DeviceRequestDto(
            name = resultRow[DeviceMasterTable.name],
            os = resultRow[DeviceMasterTable.os],
            osVersion = resultRow[DeviceMasterTable.os_version],
            deviceNumber = resultRow[DeviceMasterTable.device_number],
            createdAt = resultRow[DeviceMasterTable.created_at],
            updatedAt = resultRow[DeviceMasterTable.updated_at],
        )
    }
}