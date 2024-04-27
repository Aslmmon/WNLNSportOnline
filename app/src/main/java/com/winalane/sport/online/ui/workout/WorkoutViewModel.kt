package com.winalane.sport.online.ui.workout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winalane.sport.online.data.Sport
import com.winalane.sport.online.data.sportList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WorkoutViewModel : ViewModel() {
    private var _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading())
    val uiState: StateFlow<UiState> get() = _uiState.asStateFlow()


    private var _checkedItem: MutableStateFlow<Sport> = MutableStateFlow(sportList[0])
    val checkedItem: StateFlow<Sport> get() = _checkedItem.asStateFlow()


    init {
        getListSports()
    }

    fun getListSports() {
        viewModelScope.launch {
            try {
                _uiState.update {
                    UiState.Success(sportList)
                }
            } catch (e: Exception) {
                _uiState.update {
                    UiState.Error("error")
                }
            }

        }
    }

    fun selectItem(sport: Sport) {
        with((_uiState.value as UiState.Success).data) {
            this.forEach { it.selected = false }
            this.find { it.categoryType.categoryId == sport.categoryType.categoryId }?.selected =
                true
        }

    }


    sealed class UiState {
        data class Success(val data: MutableList<Sport>) : UiState()
        data class Error(val message: String) : UiState()
        data class Loading(val loading: Boolean = true) : UiState()

    }
}