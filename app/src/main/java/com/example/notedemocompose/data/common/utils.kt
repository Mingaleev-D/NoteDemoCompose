package com.example.notedemocompose.data.common

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * @author : Mingaleev D
 * @data : 13.05.2023
 */

fun fromDate(time: Long): String {
   val date = Date(time)
   val format = SimpleDateFormat("EEE, d MM hh:mm aaa",
                                 Locale.getDefault()
   )
   return format.format(date)
}