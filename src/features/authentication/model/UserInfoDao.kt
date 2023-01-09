package com.neci.features.authentication.model

import com.neci.features.authentication.dao.entity.UserTable
import org.jetbrains.exposed.sql.ResultRow

data class UserInfoDao(
    val id: Int? = null,
    val employeeId: String,
    val role: Int,
    val email: String,
    val firstName: String? = null,
    val lastName: String? = null,
    val designation: String? = null,
    val companyName:String? = null,
    val isDeleted: Boolean,
    val createdAt: String,
    val updatedAt: String? = null,

){
    companion object {
        fun fromRow(resultRow: ResultRow) = UserInfoDao(
            id = resultRow[UserTable.id],
            email = resultRow[UserTable.email],
            employeeId = resultRow[UserTable.employee_id],
            role = resultRow[UserTable.role],
            firstName = resultRow[UserTable.first_name],
            lastName = resultRow[UserTable.last_name],
            designation = resultRow[UserTable.designation],
            companyName = resultRow[UserTable.company_name],
            isDeleted = resultRow[UserTable.is_deleted],
            createdAt = resultRow[UserTable.created_at].toString(),
            updatedAt = resultRow[UserTable.updated_at].toString(),
        )
    }
}