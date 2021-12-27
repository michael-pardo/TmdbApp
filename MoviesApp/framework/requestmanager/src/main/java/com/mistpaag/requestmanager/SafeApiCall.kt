package com.mistpaag.requestmanager

import com.mistpaag.data.ResultData
import retrofit2.Response
import java.io.IOException

suspend fun <T : Any> safeApiCall(
    call: suspend () -> ResultData<T>,
    errorMessage: String
): ResultData<T> = try {
    call.invoke()
} catch (e: Exception) {
    ResultData.Error("$errorMessage ${e.localizedMessage}")
}

fun <T : Any> Response<T>.callServices(): ResultData<T> {
    if (this.isSuccessful) {
        return if (this.body() != null) {
            ResultData.Success(this.body() as T)
        } else{
            ResultData.Error(this.errorBody().toString())
        }
    }
    return ResultData.Error(IOException().toString())
}