package com.neci.features.authentication.dao

import com.neci.extensions.connectToExampleDatabase
import com.neci.features.authentication.dao.entity.User
import com.neci.features.authentication.dao.mapper.AuthenticationMapper
import com.neci.features.authentication.model.LoginRequestDto
import com.neci.features.authentication.model.UserInfoDto
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class AuthenticationDaoImpl(private val mapper: AuthenticationMapper) : AuthenticationDao {

    override fun login(request: LoginRequestDto): Boolean {
        Database.connectToExampleDatabase()

        val count: Long = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction User.select { User.email eq request.email }.count()
        }
        return count.toInt() == 1
    }

    override fun getUserInfo(email: String): UserInfoDto {
        Database.connectToExampleDatabase()

        val userInfo = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction mapper.fromUserDaoToUserInfo(User.select { User.email eq email }.single())
        }
        return userInfo
    }

    override fun createUser(userInfoDto: UserInfoDto) {
        Database.connectToExampleDatabase()

        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(User)
            User.insert {
                it[employee_id] = userInfoDto.employee_id
                it[email] = userInfoDto.email
                it[role] = userInfoDto.role
                it[password] = userInfoDto.password!!
            }
        }
    }
}