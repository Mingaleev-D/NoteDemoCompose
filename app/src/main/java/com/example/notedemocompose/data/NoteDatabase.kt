package com.example.notedemocompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.notedemocompose.data.common.DateConverter
import com.example.notedemocompose.data.common.UUIDConverter
import com.example.notedemocompose.model.NoteModel

/**
 * @author : Mingaleev D
 * @data : 13.05.2023
 */

@Database(entities = [NoteModel::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase() {
   abstract fun noteDao(): NoteDatabaseDao
}