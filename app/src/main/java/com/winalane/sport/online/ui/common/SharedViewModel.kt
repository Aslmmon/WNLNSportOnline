package com.winalane.sport.online.ui.common

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SharedViewModel<T> : ViewModel() {
    private val _data = mutableStateOf<T?>(null)
    val data: State<T?> = _data


    fun setData(newData: T) {
        _data.value = newData
    }

    fun clearData() {
        _data.value = null
    }
}
