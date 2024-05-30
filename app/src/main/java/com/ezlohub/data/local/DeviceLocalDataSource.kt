package com.ezlohub.data.local

import javax.inject.Inject

class DeviceLocalDataSource @Inject constructor(private val dao: DeviceDao) {
    fun getAll(): List<DeviceEntity> {
        return dao.getAll()
    }

    fun insertAll(devices: List<DeviceEntity>) {
        devices.forEach {
            dao.insert(it)
        }
    }

    suspend fun delete(pkDevice: Int) {
        dao.deleteDeviceByPk(pkDevice)
    }
}
