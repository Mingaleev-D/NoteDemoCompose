package com.example.notedemocompose.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.notedemocompose.model.NoteModel

/**
 * @author : Mingaleev D
 * @data : 10.05.2023
 */

class NoteDataSource {
    fun loadNotes(): List<NoteModel> {
      return listOf(
          NoteModel(title = "title1", description = "description1"),
          NoteModel(title = "title2", description = "description1"),
          NoteModel(title = "title3", description = "description1"),
          NoteModel(title = "title4", description = "description1"),
          NoteModel(title = "title5", description = "description1"),
          NoteModel(title = "title6", description = "description1"),
      )
   }
}