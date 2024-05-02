package com.winalane.sport.online.ui.features.add_workout

import androidx.lifecycle.ViewModel
import com.winalane.sport.online.data.SportData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddWorkOutViewModel : ViewModel() {

    private var _uiState: MutableStateFlow<SportsDataState> = MutableStateFlow(SportsDataState())
    val uiState: StateFlow<SportsDataState> get() = _uiState.asStateFlow()


    private var _sportsData: MutableStateFlow<MutableList<SportData>> = MutableStateFlow(
        mutableListOf(SportData())
    )
    val sportsData: StateFlow<MutableList<SportData>> get() = _sportsData.asStateFlow()


    fun submitProgress(date: String, categoryId: String) {
        with(_uiState.value) {
            _sportsData.value.add(
                SportData(
                    date = date,
                    duration = duration,
                    distance = distance,
                    goals = goals,
                    categoryId = categoryId

                )
            )
        }

    }

    fun getSportsData(categoryId: String): List<SportData> {
        return _sportsData.value.filter { it.categoryId == categoryId }
    }

    fun updateDuration(duration: String) {
        _uiState.update {
            it.copy(duration = duration)
        }
    }

    fun updateDistance(distance: String) {
        _uiState.update {
            it.copy(duration = distance)
        }
    }

    fun updateAmount(amount: String) {
        _uiState.update {
            it.copy(amount = amount)
        }
    }

    fun updateGoals(goals: String) {
        _uiState.update {
            it.copy(goals = goals)
        }
    }


    data class SportsDataState(
        val date: String? = null,
        val duration: String? = null,
        val distance: String? = null,
        val amount: String? = null,
        val type: String? = null,
        val goals: String? = null,
    )
}