package com.prometheus_service.midas.newsapp.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun String.toLocalDateTime() : String{
    return LocalDateTime.parse(this, DateTimeFormatter.ISO_DATE_TIME).toString()
}