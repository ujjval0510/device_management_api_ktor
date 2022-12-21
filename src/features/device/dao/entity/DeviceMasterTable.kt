package com.neci.features.device.dao.entity

import org.jetbrains.exposed.sql.Table

object DeviceMasterTable : Table("device_master") {
    val id = integer("id").autoIncrement().uniqueIndex();
    val name = varchar("name", 45)
    val os = varchar("os", 45)
    val os_version = varchar("os_version", 45)
    val is_deleted = integer("is_deleted")
    val device_number = varchar("device_number", 20)
    val created_at = varchar("created_at", 20)
    val updated_at = varchar("updated_at", 20)

    override val primaryKey = PrimaryKey(id, device_number)
}