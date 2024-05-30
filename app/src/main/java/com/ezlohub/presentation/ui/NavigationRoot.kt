package com.ezlohub.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ezlohub.domain.model.DeviceInfo
import com.ezlohub.presentation.ui.allDevicesScreen.AllDevicesScreenRoot
import com.ezlohub.presentation.ui.allDevicesScreen.AllDevicesState
import com.ezlohub.presentation.ui.allDevicesScreen.DeviceDetails

@Composable
fun NavigationRoot(
    navController: NavHostController,
    state: AllDevicesState
) {
    NavHost(
        navController = navController,
        startDestination = AllDevices.route
    ) {
        var deviceWasClicked: DeviceInfo? = null
        composable(route = AllDevices.route) {
            AllDevicesScreenRoot(
                onDeviceClick = { index ->
                    deviceWasClicked = state.devicesList[index]
                    navController.navigate(DeviceDetails.route)
                },
                state = state
            )
        }

        composable(route = DeviceDetails.route) {
            deviceWasClicked?.let { DeviceDetails(it) }
        }
    }
}

