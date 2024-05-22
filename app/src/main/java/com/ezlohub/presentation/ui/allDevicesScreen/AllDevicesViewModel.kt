package com.ezlohub.presentation.ui.allDevices

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezlohub.R
import com.ezlohub.domain.model.Device
import com.ezlohub.domain.model.DeviceInfo
import com.ezlohub.domain.repository.DeviceRepositoryImpl
import com.ezlohub.presentation.ui.DeviceDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AllDevicesViewModel @Inject constructor(private val deviceRepo: DeviceRepositoryImpl) :
    ViewModel() {

    private val _devicesState = MutableStateFlow<AllDevicesState>(AllDevicesState(emptyList()))
    val devicesState: StateFlow<AllDevicesState> = _devicesState.asStateFlow()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                async { deviceRepo.fetchDevices() }.await()
                val devicesInfoList = toDeviceInfoList(deviceRepo.getDevices())
                _devicesState.value =
                    AllDevicesState(
                        devicesInfoList,
                        R.drawable.john_wayne__portrait,
                        "John Wayne",
                    )

            }

        }
    }

    private fun toDeviceInfoList(devicesList: List<Device>): List<DeviceInfo> {
        return devicesList.mapIndexed() { index, device ->
            val imageRes = when (device.Platform) {
                "Sercomm G450" -> R.drawable.vera_plus_big
                "Sercomm G550" -> R.drawable.vera_secure_big
                "MiCasaVerde VeraLite" -> R.drawable.vera_edge_big
                "Sercomm NA900" -> R.drawable.vera_edge_big
                "Sercomm NA301" -> R.drawable.vera_edge_big
                "Sercomm NA930" -> R.drawable.vera_edge_big
                else -> R.drawable.vera_edge_big
            }

            DeviceInfo(
                imageRes,
                "Device ${index + 1}",
                "SN: ${device.PK_Device}",
                "MAC Address: ${device.MacAddress}",
                "Firmware: ${device.Firmware}",
                "Model: Vera Edge"
            )
        }.sortedBy { it.sn }
    }

    fun onAction(action: AllDevicesAction) {
        when (action) {
            AllDevicesAction.OnDeviceClick -> openDeviceDetails()
            AllDevicesAction.OnDeleteClicked -> deleteDevice()
            AllDevicesAction.OnDeviceLongClick -> openDeviceSubMenu()
            AllDevicesAction.OnCancelClicked -> closeDeviceSubMenu()
        }
    }

    private fun getDevices() {

    }

    private fun openDeviceDetails() {
    }

    private fun deleteDevice() {
    }

    private fun openDeviceSubMenu() {
    }

    private fun closeDeviceSubMenu() {

    }
}