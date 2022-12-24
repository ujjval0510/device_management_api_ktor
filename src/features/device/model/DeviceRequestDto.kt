package com.neci.features.device.model

import com.neci.features.device.dao.entity.DeviceMasterTable
import org.jetbrains.exposed.sql.ResultRow

data class DeviceRequestDto(
    val name: String,
    val os: String? = null,
    val osVersion: String? = null,
    val deviceNumber: String? = null,
)