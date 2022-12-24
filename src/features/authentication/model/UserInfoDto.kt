package com.neci.features.authentication.model

data class UserInfoDto(
    val id: Int? = null,
    val employeeId: String,
    val role: Int,
    val email: String,
    var password: String? = null,
)