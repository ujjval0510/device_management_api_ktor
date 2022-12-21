package com.neci.features.device.dao

import com.neci.extensions.connectToExampleDatabase
import com.neci.features.device.dao.entity.DeviceMasterTable
import com.neci.features.device.dao.mapper.DeviceMapper
import com.neci.features.device.model.DeviceInfoDao
import com.neci.features.device.model.DeviceRequestDto
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime

class DeviceDaoImpl(private val mapper: DeviceMapper) : DeviceDao {

    override fun getDeviceList(): List<DeviceInfoDao> {
        Database.connectToExampleDatabase()
        val deviceList = transaction {
            addLogger(StdOutSqlLogger)
            println("List of data : ====== " +  LocalDateTime.now());
            return@transaction mapper.fromDeviceDaoToDeviceList(DeviceMasterTable.selectAll().toList())
        }

        return deviceList
    }

    override fun createDevice(requestDto: DeviceRequestDto): DeviceInfoDao {
        TODO("Not yet implemented")
    }


//    override fun getDeviceInfo(deviceId: Int): Device {
//        Database.connectToExampleDatabase()

//        val deviceInfo = transaction {
//            addLogger(StdOutSqlLogger)
//            return@transaction mapper.fromDeviceDaoToDeviceInfo(Device.select { Device.id eq deviceId }.single())
//        }
//        return deviceInfo
//    }

//    override fun addDevice(deviceInfoDto: DeviceInfoDto) {
//        Database.connectToExampleDatabase()
//
//        transaction {
//            addLogger(StdOutSqlLogger)
//            SchemaUtils.create(Device)
//            Device.insert {
//                it[device_number] = deviceInfoDto.device_number
//                it[os] = deviceInfoDto.os
//                it[os_version] = deviceInfoDto.os_version
//                it[name] = deviceInfoDto.name
//            }
//        }
//    }

}