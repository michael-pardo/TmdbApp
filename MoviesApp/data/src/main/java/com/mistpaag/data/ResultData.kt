package com.mistpaag.data

sealed class ResultData<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResultData<T>()
    data class Error(val message: String) : ResultData<Nothing>()
}


fun <T : Any> ResultData<T>.isSuccess(): Boolean = when (this) {
    is ResultData.Success -> true
    is ResultData.Error -> false
}

fun <T : Any> ResultData<T>.isError(): Boolean = when (this) {
    is ResultData.Error -> true
    is ResultData.Success -> false
}

fun <T: Any> ResultData<T>.getError() = when (this) {
    is ResultData.Error -> message
    else -> null
}

fun <T: Any> ResultData<T>.getSuccess() = when (this) {
    is ResultData.Success -> data
    else -> null
}