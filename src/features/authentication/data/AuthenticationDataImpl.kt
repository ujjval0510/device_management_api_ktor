package com.neci.features.authentication.data

import com.neci.features.authentication.dao.AuthenticationDao
import com.neci.features.authentication.model.LoginRequestDto
import com.neci.features.authentication.model.UpdateUserInfoDto
import com.neci.features.authentication.model.UserInfoDto
import com.neci.jwt.JwtManager

class AuthenticationDataImpl(private val authenticationDao: AuthenticationDao, private val jwtManager: JwtManager) :
    AuthenticationData {
    override fun login(request: LoginRequestDto): String {
        if (authenticationDao.login(request)) {
            return jwtManager.generateToken(request)
        } else {
            throw Exception("User not found")
        }
    }

    override fun getUserInfo(email: String): UserInfoDto {
        return authenticationDao.getUserInfo(email).apply { password = null }
    }

    override fun createUser(userInfoDto: UserInfoDto) : UserInfoDto {
        return authenticationDao.createUser(userInfoDto)
    }
    override fun updateUser(userInfoDto: UpdateUserInfoDto): UserInfoDto {
        return authenticationDao.updateUser(userInfoDto)
    }
    override fun deleteUser(userID: Int) {
        return authenticationDao.deleteUser(userID)
    }
}