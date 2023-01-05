package com.neci.features.device.dao.entity

import org.jetbrains.exposed.sql.Table

object DeviceMasterTable : Table("device_master") {
    val id = integer("id").autoIncrement().uniqueIndex()
    val name = varchar("name", 50)
    val os = varchar("os", 50).nullable()
    val os_version = varchar("os_version", 50).nullable()
    val is_deleted = integer("is_deleted")
    val device_number = varchar("device_number", 50).nullable()
    val created_at = varchar("created_at", 50)
    val updated_at = varchar("updated_at", 50)

    override val primaryKey = PrimaryKey(id, device_number)
}