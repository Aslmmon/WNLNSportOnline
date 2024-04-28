package com.winalane.sport.online.ui.common

import android.content.Context
import java.text.SimpleDateFormat
import java.util.Date


fun Context?.getcurrentDate(): String {
    val sdf = SimpleDateFormat("dd.MM.yyyy")
    val currentDate = sdf.format(Date())
    return currentDate
}