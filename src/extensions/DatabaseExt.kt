package com.neci.extensions

import com.typesafe.config.ConfigFactory
import org.jetbrains.exposed.sql.Database

fun Database.Companion.connectToExampleDatabase() {
    val conf = ConfigFactory.load()
    connect(
        url = conf.getString("database.databaseUrl"),
        driver = conf.getString("database.databaseDriver"),
        user = conf.getString("database.databaseUser"),
        password = conf.getString("database.databasePassword")
    )
}