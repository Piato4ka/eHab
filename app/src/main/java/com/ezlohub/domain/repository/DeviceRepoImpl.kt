package com.ezlohub.domain.repository

import android.util.Log
import com.ezlohub.data.local.DeviceEntity
import com.ezlohub.data.local.DeviceLocalDataSource
import com.ezlohub.data.remote.DeviceRemoteDateSource
import com.ezlohub.domain.model.Device
import com.ezlohub.domain.model.DeviceResponse
import javax.inject.Inject

class DeviceRepositoryImpl @Inject constructor(
    private val localDataSource: DeviceLocalDataSource,
    private val remoteDataSource: DeviceRemoteDateSource
) : DeviceRepo {

    override suspend fun fetchDevices() {
        val localDevices = localDataSource.getAll()
        if (localDevices.isEmpty()) {
            remoteDataSource.fetchDevices().collect { result ->
                if (result.isSuccess) {
                    result.getOrNull()?.let {
                        localDataSource.insertAll(convertRemoteToLocal(it))
                    }
                } else {
                    Log.e("MyTag", "Error fetching devices")
                }
            }
        }
    }

    override suspend fun getDevices(): List<Device> {
        return localDataSource.getAll().map {
            Device(
                it.pkDevice,
                it.macAddress,
                it.pkDeviceType.toInt(),
                it.pkDeviceSubType.toInt(),
                it.firmware,
                it.serverDevice,
                it.serverEvent,
                it.serverAccount,
                it.internalIp,
                it.lastAliveReported,
                it.platform
            )
        }
    }

    override suspend fun deleteDevice(device: Device) {
        localDataSource.delete(device.PK_Device)
    }


    private fun convertRemoteToLocal(remoteDevices: DeviceResponse): List<DeviceEntity> {
        return remoteDevices.Devices.map {
            DeviceEntity(
                it.PK_Device,
                it.MacAddress,
                it.PK_DeviceType.toString(),
                it.PK_DeviceSubType.toString(),
                it.Firmware,
                it.Server_Device,
                it.Server_Event,
                it.Server_Account,
                it.InternalIP,
                it.LastAliveReported,
                it.Platform
            )
        }
    }


}