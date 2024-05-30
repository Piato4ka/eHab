package com.ezlohub.presentation.ui

interface AppDestinations {
    val route: String
}

object AllDevices : AppDestinations {
    override val route = "allDevices"
}

object DeviceDetails : AppDestinations {
    override val route = "deviceInfo"
}