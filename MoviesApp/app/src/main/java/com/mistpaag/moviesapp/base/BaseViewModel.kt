package com.mistpaag.moviesapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<ST>() : ViewModel() {
    protected val _state= MutableLiveData<ST>()
    val state: LiveData<ST>
        get() = _state
}