package com.ezlohub.data.remote

import com.ezlohub.domain.model.DeviceResponse
import retrofit2.http.GET

interface ApiService {
    @GET("test_android/items.test")
    suspend fun getDevices(): DeviceResponse
}