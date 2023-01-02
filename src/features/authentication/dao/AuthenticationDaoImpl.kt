package com.neci.features.authentication.dao

import com.neci.extensions.connectToExampleDatabase
import com.neci.features.authentication.dao.entity.UserTable
import com.neci.features.authentication.dao.mapper.AuthenticationMapper
import com.neci.features.authentication.model.LoginRequestDto
import com.neci.features.authentication.model.UpdateUserInfoDto
import com.neci.features.authentication.model.UserInfoDto
import com.neci.features.device.dao.entity.DeviceMasterTable
import com.neci.features.device.model.DeviceInfoDao
import com.neci.features.device.model.UpdateDeviceRequestDto
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime
import java.time.LocalTime

class AuthenticationDaoImpl(private val mapper: AuthenticationMapper) : AuthenticationDao {

    override fun login(request: LoginRequestDto): Boolean {
        Database.connectToExampleDatabase()

        val count: Long = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction UserTable.select { UserTable.email eq request.email }.count()
        }
        return count.toInt() == 1
    }

    override fun getUserInfo(email: String): UserInfoDto {
        Database.connectToExampleDatabase()

        val userInfo = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction mapper.fromUserDaoToUserInfo(UserTable.select { UserTable.email eq email }.single())
        }
        return userInfo
    }

    override fun createUser(userInfoDto: UserInfoDto): UserInfoDto {
        Database.connectToExampleDatabase()

        return transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(UserTable)
            val email = UserTable.insert {
                it[employee_id] = userInfoDto.employeeId
                it[email] = userInfoDto.email
                it[role] = userInfoDto.role
                it[password] = userInfoDto.password!!
                it[created_at] = LocalDateTime.now().toString()
                it[updated_at] = LocalDateTime.now().toString()
            } get UserTable.email
            transaction {
                addLogger(StdOutSqlLogger)
                return@transaction mapper.fromUserDaoToUserInfo(UserTable.select { UserTable.email eq email }
                    .single())
            }
        }
    }
    override fun updateUser(userInfoDto: UpdateUserInfoDto): UserInfoDto {
        Database.connectToExampleDatabase()
        val updateUserDao = transaction {
            UserTable.update ({UserTable.id eq userInfoDto.id!!.toInt() }){
                it[is_deleted] = userInfoDto.isDeleted
                it[first_name] = userInfoDto.firstName
                it[last_name] = userInfoDto.lastName
                it[designation] = userInfoDto.designation
                it[company_name] = userInfoDto.companyName
                it[updated_at] = LocalDateTime.now().toString()
            }
            transaction {
                addLogger(StdOutSqlLogger)
                return@transaction mapper.fromUserDaoToUserInfo(UserTable.select { UserTable.id eq userInfoDto.id!!.toInt() }
                    .single())
            }
        }
        return updateUserDao
    }
    override fun deleteUser(userID: Int) {
        Database.connectToExampleDatabase()
        transaction {
            addLogger(StdOutSqlLogger)
            mapper.fromUserDaoToUserInfo(UserTable.select { UserTable.id eq userID }.single())
            UserTable.update ({UserTable.id eq userID }){
                it[is_deleted] = true
                it[updated_at] = LocalDateTime.now().toString()
            }
        }
    }
}