package com.neci.features.authentication.dao.mapper

import com.neci.features.authentication.dao.entity.User
import com.neci.features.authentication.model.UserInfoDto
import org.jetbrains.exposed.sql.ResultRow

class AuthenticationMapperImpl : AuthenticationMapper {

    override fun fromUserDaoToUserInfo(resultRow: ResultRow) = UserInfoDto(
//        id = resultRow[User.id],
        email = resultRow[User.email],
        employee_id = resultRow[User.employee_id],
        role = resultRow[User.role],
    )

}