package com.neci.features.authentication.dao.entity

import org.jetbrains.exposed.sql.Table

object UserTable : Table("user") {
    val id = integer("id").autoIncrement().uniqueIndex();
    val employee_id = varchar("employee_id", 50)
    val role = integer("role")
    val email = varchar("email", 50)
    val password = varchar("password",50)
    val created_at = varchar("created_at", 50)
    val updated_at = varchar("updated_at", 50)
    val is_deleted = bool("is_deleted")
    val first_name = varchar("first_name", 50)
    val last_name = varchar("last_name", 50)
    val company_name = varchar("company_name", 50)
    val designation = varchar("designation", 50)

    override val primaryKey = PrimaryKey(id, email)
}