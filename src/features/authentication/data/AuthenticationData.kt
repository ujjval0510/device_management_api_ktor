package com.neci.features.authentication.data

import com.neci.features.authentication.model.LoginRequestDto
import com.neci.features.authentication.model.UpdateUserInfoDto
import com.neci.features.authentication.model.UserInfoDto

interface AuthenticationData {
    fun login(request: LoginRequestDto): String
    fun getUserInfo(email:String): UserInfoDto
    fun createUser(userInfoDto: UserInfoDto): UserInfoDto
    fun updateUser(userInfoDto: UpdateUserInfoDto): UserInfoDto
    fun deleteUser(userID: Int)
}