package com.neci.features.authentication.dao

import com.neci.features.authentication.model.LoginRequestDto
import com.neci.features.authentication.model.UserInfoDto

interface AuthenticationDao {
    fun login(request: LoginRequestDto): Boolean
    fun getUserInfo(email:String): UserInfoDto
    fun createUser(userInfoDto: UserInfoDto)
}