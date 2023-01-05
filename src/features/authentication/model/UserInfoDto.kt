package com.neci.features.authentication.model

data class UserInfoDto(
    val id: Int? = null,
    val employeeId: String,
    val role: Int,
    val email: String,
    var password: String? = null,
    val firstName: String,
    val lastName: String,
    val designation: String,
    val companyName:String,
    val isDeleted: Boolean
)