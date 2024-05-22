package com.ezlohub.presentation.ui.allDevices

import com.ezlohub.domain.model.Device
import com.ezlohub.domain.model.DeviceInfo

data class AllDevicesState (
    val devicesList: List<DeviceInfo> = emptyList(),
    val avatarImageRes: Int = 0,
    val userName: String = "Mr Null",
)