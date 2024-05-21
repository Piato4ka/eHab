package com.ezlohub.presentation.ui.allDevices

sealed interface AllDevicesAction {
    data object OnDeviceClick: AllDevicesAction
    data object OnDeviceLongClick: AllDevicesAction
    data object OnDeleteClicked: AllDevicesAction
    data object OnCancelClicked: AllDevicesAction
}