package com.example.notedemocompose.data.common

import androidx.room.TypeConverter
import java.util.UUID

/**
 * @author : Mingaleev D
 * @data : 13.05.2023
 */

class UUIDConverter {

   @TypeConverter
   fun fromUUID(uuid: UUID): String? {
      return uuid.toString()
   }

   @TypeConverter
   fun uuidFromString(string: String?): UUID {
      return UUID.fromString(string)
   }

}