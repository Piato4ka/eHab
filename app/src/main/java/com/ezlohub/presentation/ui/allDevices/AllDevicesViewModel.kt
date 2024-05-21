package com.ezlohub.presentation.ui.allDevices

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AllDevicesViewModel(): ViewModel() {

    var state by mutableStateOf(AllDevicesState())
        private set

    fun onAction (action: AllDevicesAction) {
        when(action) {
            AllDevicesAction.OnDeviceClick -> openDeviceDetails()
            AllDevicesAction.OnDeleteClicked -> deleteDevice()
            AllDevicesAction.OnDeviceLongClick -> openDeviceSubMenu()
            AllDevicesAction.OnCancelClicked -> closeDeviceSubMenu()
        }
    }

    private fun openDeviceDetails() {
    }

    private fun deleteDevice() {
    }

    private fun openDeviceSubMenu () {
    }

    private fun closeDeviceSubMenu(){

    }
}