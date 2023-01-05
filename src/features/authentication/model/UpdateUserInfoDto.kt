package com.neci.features.authentication.model

data class UpdateUserInfoDto(
    val id: Int? = null,
    val firstName: String,
    val lastName: String,
    val designation: String,
    val companyName:String,
    val isDeleted: Boolean
)