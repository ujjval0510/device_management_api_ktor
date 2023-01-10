package com.neci.features.authentication.dao.mapper

import com.neci.features.authentication.dao.entity.UserTable
import com.neci.features.authentication.model.UserInfoDao
import com.neci.features.authentication.model.UserInfoDto
import com.neci.features.device.model.DeviceInfoDao
import org.jetbrains.exposed.sql.ResultRow

class AuthenticationMapperImpl : AuthenticationMapper {

    override fun fromUserDaoToUserInfo(resultRow: ResultRow) = UserInfoDto(
        id = resultRow[UserTable.id],
        email = resultRow[UserTable.email],
        employeeId = resultRow[UserTable.employee_id],
        role = resultRow[UserTable.role],
        firstName = resultRow[UserTable.first_name],
        lastName = resultRow[UserTable.last_name],
        designation = resultRow[UserTable.designation],
        companyName = resultRow[UserTable.company_name],
        isDeleted = resultRow[UserTable.is_deleted]
    )

    override fun fromUserDaoToUserList(resultRow: List<ResultRow>): List<UserInfoDao> {
        return resultRow.map { UserInfoDao.fromRow(it) }
    }

}