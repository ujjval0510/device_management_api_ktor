package com.neci.features.device.model


data class UpdateDeviceRequestDto(
    val id: Int,
    val name: String,
    val os: String? = null,
    val osVersion: String? = null,
    val deviceNumber: String? = null,
)