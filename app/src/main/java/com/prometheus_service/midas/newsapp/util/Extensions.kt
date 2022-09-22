package com.prometheus_service.midas.newsapp.util

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("SimpleDateFormat")
@RequiresApi(Build.VERSION_CODES.O)
fun String.toLocalDateTime(): String {
    val date = LocalDateTime.parse(this, DateTimeFormatter.ISO_DATE_TIME)
    return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
}