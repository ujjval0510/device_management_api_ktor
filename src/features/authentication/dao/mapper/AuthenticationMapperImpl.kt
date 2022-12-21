package com.neci.features.authentication.dao.mapper

import com.neci.features.authentication.dao.entity.UserTable
import com.neci.features.authentication.model.UserInfoDto
import org.jetbrains.exposed.sql.ResultRow

class AuthenticationMapperImpl : AuthenticationMapper {

    override fun fromUserDaoToUserInfo(resultRow: ResultRow) = UserInfoDto(
//        id = resultRow[User.id],
        email = resultRow[UserTable.email],
        employeeId = resultRow[UserTable.employee_id],
        role = resultRow[UserTable.role],
    )

}