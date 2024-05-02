package com.winalane.sport.online.ui.common

import android.annotation.SuppressLint
import android.content.Context
import java.text.SimpleDateFormat
import java.util.Date


@SuppressLint("SimpleDateFormat")
fun Context?.getcurrentDate(): String {
    val sdf = SimpleDateFormat("dd.MM.yyyy")
    return sdf.format(Date())
}