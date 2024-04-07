package com.winalane.sport.online.ui.workout

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winalane.sport.online.data.Sport
import com.winalane.sport.online.data.sportList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WorkoutViewModel : ViewModel() {
    private var _listSports: MutableStateFlow<UiState> = MutableStateFlow(
        UiState.Loading()
    )
    val listSports: MutableStateFlow<UiState> get() = _listSports
    var newList = sportList


    init {
        getListSports()
    }

    fun getListSports() {
        viewModelScope.launch {
            delay(3000L)
            try {
                _listSports.update {
                    UiState.Success(newList)
                }
            } catch (e: Exception) {
                _listSports.update {
                    UiState.Error("error")
                }
            }

        }
    }

    fun selectItem(id: Int) {
        newList.find { it.categoryType.categoryId == id }?.isSelected = true
        _listSports.getAndUpdate {
            UiState.Success(newList)
        }


    }


    sealed class UiState {
        data class Success(val data: MutableList<Sport>) : UiState()
        data class Error(val message: String) : UiState()
        class Loading : UiState()

    }
}