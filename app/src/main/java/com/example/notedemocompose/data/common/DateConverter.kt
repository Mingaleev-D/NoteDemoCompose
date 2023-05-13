package com.example.notedemocompose.data.common

import androidx.room.TypeConverter
import java.util.Date

/**
 * @author : Mingaleev D
 * @data : 13.05.2023
 */

class DateConverter {

   @TypeConverter
   fun timeStampFromDate(date: Date): Long {
      return date.time
   }

   @TypeConverter
   fun dateFromTimesTime(timestamp: Long): Date? {
      return Date(timestamp)
   }
}