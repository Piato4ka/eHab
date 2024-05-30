package com.ezlohub.data.remote

import android.util.Log
import com.ezlohub.domain.model.DeviceResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeviceRemoteDateSource @Inject constructor(private val api: ApiService) {

    suspend fun fetchDevices(): Flow<Result<DeviceResponse>> {
        return flow {
            emit(Result.success(api.getDevices()))
        }.catch {
            Log.e("MyTag", "api error - ${it.message.toString()}")
            emit(Result.failure(RuntimeException("Something went wrong")))
        }
    }

}