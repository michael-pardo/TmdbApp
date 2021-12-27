package com.mistpaag.data.source

interface ConnectivityChecker {
    fun isInternetAvailable(): Boolean
}