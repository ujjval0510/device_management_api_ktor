package com.neci.features.device.dao

import com.neci.extensions.connectToExampleDatabase
import com.neci.features.device.dao.entity.DeviceMasterTable
import com.neci.features.device.dao.mapper.DeviceMapper
import com.neci.features.device.model.DeviceInfoDao
import com.neci.features.device.model.DeviceRequestDto
import com.neci.features.device.model.UpdateDeviceRequestDto
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime

class DeviceDaoImpl(private val mapper: DeviceMapper) : DeviceDao {

    override fun getDeviceList(): List<DeviceInfoDao> {
        Database.connectToExampleDatabase()
        val deviceList = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction mapper.fromDeviceDaoToDeviceList(DeviceMasterTable.selectAll().toList())
        }

        return deviceList
    }


    override fun createDevice(requestDto: DeviceRequestDto): DeviceInfoDao {
        Database.connectToExampleDatabase()
        val deviceInfoDao = transaction {
            addLogger(StdOutSqlLogger)
            val id = DeviceMasterTable.insert {
                it[name] = requestDto.name
                it[os] = requestDto.os
                it[os_version] = requestDto.osVersion
                it[device_number] = requestDto.deviceNumber
                it[created_at] = LocalDateTime.now().toString()
                it[updated_at] = LocalDateTime.now().toString()
                it[is_deleted] = 0
            } get DeviceMasterTable.id
            transaction {
                addLogger(StdOutSqlLogger)
                return@transaction mapper.fromDeviceDaoToDeviceInfo(DeviceMasterTable.select { DeviceMasterTable.id eq id }
                    .single())
            }
        }

        println("deviceInfoDao : $deviceInfoDao")

        return deviceInfoDao;
    }

    override fun updateDevice(requestDto: UpdateDeviceRequestDto): DeviceInfoDao {
        Database.connectToExampleDatabase()
        val deviceInfoDao = transaction {
            DeviceMasterTable.update({ DeviceMasterTable.id eq requestDto.id }) {
                it[name] = requestDto.name
                it[os] = requestDto.os
                it[os_version] = requestDto.osVersion
                it[device_number] = requestDto.deviceNumber
                it[updated_at] = LocalDateTime.now().toString()
            }
            transaction {
                addLogger(StdOutSqlLogger)
                return@transaction mapper.fromDeviceDaoToDeviceInfo(DeviceMasterTable.select { DeviceMasterTable.id eq requestDto.id }
                    .single())

            }
        }
        return deviceInfoDao;
    }

    override fun deleteDevice(deviceId: Int) {
        Database.connectToExampleDatabase()
        transaction {
            addLogger(StdOutSqlLogger)
            val deviceIFO =
                mapper.fromDeviceDaoToDeviceInfo(DeviceMasterTable.select { DeviceMasterTable.id eq deviceId }
                    .single())
            DeviceMasterTable.update({ DeviceMasterTable.id eq deviceId }) {
                if (deviceIFO.isDeleted?.equals(0) == true) {
                    it[is_deleted] = 1
                    it[updated_at] = LocalDateTime.now().toString()
                }
            }
        }
    }

    override fun getDeviceInfo(deviceId: Int): DeviceInfoDao {
        Database.connectToExampleDatabase()

        val deviceInfo = transaction {
            addLogger(StdOutSqlLogger)
            return@transaction mapper.fromDeviceDaoToDeviceInfo(DeviceMasterTable.select { DeviceMasterTable.id eq deviceId }.single())
        }
        return deviceInfo
    }

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