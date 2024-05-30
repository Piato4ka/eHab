package com.ezlohub.domain.model

data class DeviceResponse(val Devices: List<Device>)

data class Device(
    val PK_Device: Int,
    val MacAddress: String,
    val PK_DeviceType: Int,
    val PK_DeviceSubType: Int,
    val Firmware: String,
    val Server_Device: String,
    val Server_Event: String,
    val Server_Account: String,
    val InternalIP: String,
    val LastAliveReported: String,
    val Platform: String
)