package com.neci.features.authentication.data

import com.neci.features.authentication.model.LoginRequestDto
import com.neci.features.authentication.model.UserInfoDto

interface AuthenticationData {
    fun login(request: LoginRequestDto): String
    fun getUserInfo(email:String): UserInfoDto
    fun createUser(userInfoDto: UserInfoDto): UserInfoDto
}