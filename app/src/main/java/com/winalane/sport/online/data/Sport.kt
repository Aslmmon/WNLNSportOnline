package com.winalane.sport.online.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.winalane.sport.online.R


/**
 * for Row
 */
data class Sport(
    val name: String,
    val icon: Int,
    val sporty: SPORTY,
    val categoryType: CategoryType,
    var initialSelectedValue: Boolean
) {
    var selected by mutableStateOf(initialSelectedValue)
}

/**
 * for Saving
 */
data class SportData(
    val date: String,
    val categoryId: Int,
    val durationBicycle: String? = null,
    val distanceBicycle: String? = null,
    val durationRunning: String? = null,
    val distanceRunning: String? = null,
    val durationFootball: String? = null,
    val goalsFootball: String? = null,
    val goals: String? = null,
    val amountPushUps: String? = null,
    val typePushUps: String? = null,
    val amountLegRaised: String? = null,
    val typeLegRaises: String? = null,
    val amountDeadLeft: String? = null,
    val amountBenchPress: String? = null,

    )


enum class SPORTY {
    TWOEDITTEXT, SPINNERANDEDITTEXT, ONEEDITTEXT
}

enum class CategoryType(var categoryId: Int) {
    Football(1), Bike(2), Running(3), PushUps(4),
    AbsExercise(5), DeadlifT(6), BenchPress(7)
}

var sportList = mutableStateListOf(
    Sport(
        name = CategoryType.Football.name,
        icon = R.drawable.football_icon,
        sporty = SPORTY.TWOEDITTEXT,
        categoryType = CategoryType.Football,
        initialSelectedValue = true

    ),
    Sport(
        name = CategoryType.Bike.name,
        icon = R.drawable.bike_icon,
        sporty = SPORTY.TWOEDITTEXT,
        categoryType = CategoryType.Bike,
        initialSelectedValue = false

    ),
    Sport(
        name = CategoryType.Running.name,
        icon = R.drawable.running_icon,
        sporty = SPORTY.TWOEDITTEXT,
        categoryType = CategoryType.Running,
        initialSelectedValue = false

    ),
    Sport(
        name = CategoryType.PushUps.name,
        icon = R.drawable.pushup_icon,
        sporty = SPORTY.SPINNERANDEDITTEXT,
        categoryType = CategoryType.PushUps,
        initialSelectedValue = false

    ),
    Sport(
        name = CategoryType.AbsExercise.name,
        icon = R.drawable.abs_icon,
        sporty = SPORTY.SPINNERANDEDITTEXT,
        categoryType = CategoryType.AbsExercise,
        initialSelectedValue = false

    ),
    Sport(
        name = CategoryType.DeadlifT.name,
        icon = R.drawable.deadlift_icon,
        sporty = SPORTY.ONEEDITTEXT,
        categoryType = CategoryType.DeadlifT,
        initialSelectedValue = false

    ),
    Sport(
        name = CategoryType.BenchPress.name,
        icon = R.drawable.deadlift_icon,
        sporty = SPORTY.ONEEDITTEXT,
        categoryType = CategoryType.BenchPress,
        initialSelectedValue = false

    )

)