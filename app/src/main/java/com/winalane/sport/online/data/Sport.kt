package com.winalane.sport.online.data

import com.winalane.sport.online.R


/**
 * for Row
 */
data class Sport(
    val name: String,
    val icon: Int,
    val sporty: SPORTY,
    val categoryType: CategoryType,
    var isSelected: Boolean = false
)

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

enum class CategoryType(type: Int) {
    Football(1), Bike(2), Running(3), PushUps(4),
    AbsExercise(5), DeadlifT(6), BenchPress(7)
}

val sportList = mutableListOf(
    Sport(
        name = CategoryType.Football.name,
        icon = R.drawable.football_icon,
        sporty = SPORTY.TWOEDITTEXT,
        categoryType = CategoryType.Football
    ),
    Sport(
        name = CategoryType.Bike.name,
        icon =  R.drawable.bike_icon,
        sporty = SPORTY.TWOEDITTEXT,
        categoryType = CategoryType.Bike
    ),
    Sport(
        name = CategoryType.Running.name,
        icon =  R.drawable.running_icon,
        sporty = SPORTY.TWOEDITTEXT,
        categoryType = CategoryType.Running
    ),
    Sport(
        name = CategoryType.PushUps.name,
        icon =  R.drawable.pushup_icon,
        sporty = SPORTY.SPINNERANDEDITTEXT,
        categoryType = CategoryType.PushUps
    ),
    Sport(
        name = CategoryType.AbsExercise.name,
        icon =  R.drawable.abs_icon,
        sporty = SPORTY.SPINNERANDEDITTEXT,
        categoryType = CategoryType.AbsExercise
    ),
    Sport(
        name = CategoryType.DeadlifT.name,
        icon =  R.drawable.deadlift_icon,
        sporty = SPORTY.ONEEDITTEXT,
        categoryType = CategoryType.DeadlifT
    ),
    Sport(
        name = CategoryType.BenchPress.name,
        icon =  R.drawable.deadlift_icon,
        sporty = SPORTY.ONEEDITTEXT,
        categoryType = CategoryType.BenchPress
    )

)