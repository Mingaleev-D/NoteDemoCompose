package com.example.notedemocompose.repository

import com.example.notedemocompose.data.NoteDatabaseDao
import com.example.notedemocompose.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 13.05.2023
 */

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {

   suspend fun addNote(note: NoteModel) = noteDatabaseDao.insert(note)
   suspend fun updateNote(note: NoteModel) = noteDatabaseDao.update(note)
   suspend fun deleteNote(note: NoteModel) = noteDatabaseDao.deleteNote(note)
   suspend fun deleteAllNotes() = noteDatabaseDao.deleteAll()
   fun getAllNotes(): Flow<List<NoteModel>> = noteDatabaseDao.getNotes()
      .flowOn(Dispatchers.IO)
      .conflate()
}