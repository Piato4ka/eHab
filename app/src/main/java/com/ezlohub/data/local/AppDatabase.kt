package com.ezlohub.data.local

import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase

@Database(entities = [DeviceEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun deviceDao(): DeviceDao
}

@Entity(tableName = "devices")
data class DeviceEntity(
    @PrimaryKey
    val pkDevice: Int,
    val macAddress: String,
    val pkDeviceType: String,
    val pkDeviceSubType: String,
    val firmware: String,
    val serverDevice: String,
    val serverEvent: String,
    val serverAccount: String,
    val internalIp: String,
    val lastAliveReported: String,
    val platform: String
)