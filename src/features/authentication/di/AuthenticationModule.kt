package com.neci.features.authentication.di

import com.neci.features.authentication.dao.AuthenticationDao
import com.neci.features.authentication.dao.AuthenticationDaoImpl
import com.neci.features.authentication.dao.mapper.AuthenticationMapper
import com.neci.features.authentication.dao.mapper.AuthenticationMapperImpl
import com.neci.features.authentication.data.AuthenticationData
import com.neci.features.authentication.data.AuthenticationDataImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val authenticationModule = module {
    single { AuthenticationDaoImpl(get()) } bind AuthenticationDao::class
    single { AuthenticationDataImpl(get(), get()) } bind AuthenticationData::class
    factory { AuthenticationMapperImpl() } bind AuthenticationMapper::class
}