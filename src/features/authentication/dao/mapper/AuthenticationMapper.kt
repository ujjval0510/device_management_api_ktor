package com.neci.features.authentication.dao.mapper

import com.neci.features.authentication.model.UserInfoDto
import org.jetbrains.exposed.sql.ResultRow

interface AuthenticationMapper {
    fun fromUserDaoToUserInfo(resultRow: ResultRow): UserInfoDto
}