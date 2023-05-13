package com.example.notedemocompose.ui.screen.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notedemocompose.data.NoteDataSource
import com.example.notedemocompose.model.NoteModel
import com.example.notedemocompose.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 12.05.2023
 */

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

   private val _noteList = MutableStateFlow<List<NoteModel>>(emptyList())
   val noteList = _noteList.asStateFlow()

   init {
      viewModelScope.launch(Dispatchers.IO) {
         repository.getAllNotes()
            .distinctUntilChanged()
            .collect { listOfNotes ->
               if (listOfNotes.isNullOrEmpty()) {
                  //TODO: see if the list is empty
               } else {
                  _noteList.value = listOfNotes
               }
            }
      }
   }

   fun addNote(note: NoteModel) = viewModelScope.launch {
      repository.updateNote(note)
   }

   fun removeNote(note: NoteModel) = viewModelScope.launch {
      repository.deleteNote(note)
   }

   fun updateNote(note: NoteModel) = viewModelScope.launch {
      repository.updateNote(note)
   }
}