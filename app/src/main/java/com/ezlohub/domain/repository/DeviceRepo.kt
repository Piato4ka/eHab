package com.ezlohub.domain.repository

import com.ezlohub.domain.model.Device

interface DeviceRepo {
    suspend fun fetchDevices()

    suspend fun getDevices(): List<Device>

    suspend fun deleteDevice(device: Device)
}