package com.ezloHub.listFeature.presentation.ui.allDevices

import androidx.annotation.StringRes

data class AllDevicesState (
    val devicesList: List<Any> = emptyList(),
    val avatarImageRes: Int = 0,
    val userName: String = "Mr Null",
)