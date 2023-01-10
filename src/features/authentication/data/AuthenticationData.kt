package com.neci.features.authentication.data

import com.neci.features.authentication.model.LoginRequestDto
import com.neci.features.authentication.model.UpdateUserInfoDto
import com.neci.features.authentication.model.UserInfoDao
import com.neci.features.authentication.model.UserInfoDto
import com.neci.features.device.model.DeviceInfoDao

interface AuthenticationData {
    fun login(request: LoginRequestDto): String
    fun getUserInfo(email:String): UserInfoDto
    fun createUser(userInfoDto: UserInfoDto): UserInfoDto
    fun updateUser(userInfoDto: UpdateUserInfoDto): UserInfoDto
    fun deleteUser(userID: Int)
    suspend fun getAllUserList(): List<UserInfoDao>
}