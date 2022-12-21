package com.neci.features.device.di

import com.neci.features.device.dao.DeviceDao
import com.neci.features.device.dao.DeviceDaoImpl
import com.neci.features.device.dao.mapper.DeviceMapper
import com.neci.features.device.dao.mapper.DeviceMapperImpl
import com.neci.features.device.data.DeviceData
import com.neci.features.device.data.DeviceDataImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val deviceDataModule = module {
    single { DeviceDaoImpl(get()) } bind DeviceDao::class
    single { DeviceDataImpl(get()) } bind DeviceData::class
    factory { DeviceMapperImpl() } bind DeviceMapper::class

}