package com.ezlohub.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DeviceDao {

    @Query("SELECT * FROM devices")
    fun getAll(): List<DeviceEntity>

    @Insert
    fun insert(vararg device: DeviceEntity)

    @Query("DELETE FROM devices WHERE pkDevice = :pkDevice")
    suspend fun deleteDeviceByPk(pkDevice: Int): Int
}