package com.ezlohub.presentation.ui.allDevices

data class AllDevicesState (
    val devicesList: List<DeviceInfo> = emptyList(),
    val avatarImageRes: Int = 0,
    val userName: String = "Mr Null",
)