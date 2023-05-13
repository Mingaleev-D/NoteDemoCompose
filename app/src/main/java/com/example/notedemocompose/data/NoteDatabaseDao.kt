package com.example.notedemocompose.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notedemocompose.model.NoteModel
import kotlinx.coroutines.flow.Flow

/**
 * @author : Mingaleev D
 * @data : 13.05.2023
 */

@Dao
interface NoteDatabaseDao {

   @Query("SELECT * FROM notes_table")
   fun getNotes(): Flow<List<NoteModel>>

   @Query("SELECT * FROM notes_table WHERE id =:id")
   suspend fun getNoteById(id: String): NoteModel

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insert(note: NoteModel)

   @Update(onConflict = OnConflictStrategy.REPLACE)
   suspend fun update(note: NoteModel)

   @Query("DELETE FROM notes_table")
   suspend fun deleteAll()

   @Delete
   suspend fun deleteNote(note: NoteModel)
}