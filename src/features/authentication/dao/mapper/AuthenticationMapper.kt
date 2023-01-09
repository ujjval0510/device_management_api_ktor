package com.neci.features.authentication.dao.mapper

import com.neci.features.authentication.model.UserInfoDao
import com.neci.features.authentication.model.UserInfoDto
import com.neci.features.device.model.DeviceInfoDao
import org.jetbrains.exposed.sql.ResultRow

interface AuthenticationMapper {
    fun fromUserDaoToUserInfo(resultRow: ResultRow): UserInfoDto
    fun fromUserDaoToUserList(resultRow: List<ResultRow>): List<UserInfoDao>
}