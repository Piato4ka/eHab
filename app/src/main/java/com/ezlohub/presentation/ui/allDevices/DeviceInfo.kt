package com.ezlohub.presentation.ui.allDevices

data class DeviceInfo (
    val imageRes: Int,
    val name: String,
    val sn: String,
    val macAddress: String,
    val firmware: String,
    val model: String,
)