package com.example.notedemocompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notedemocompose.ui.screen.NoteScreen
import com.example.notedemocompose.ui.screen.viewmodel.NoteViewModel
import com.example.notedemocompose.ui.theme.NoteDemoComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         NoteDemoComposeTheme {
            Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
            ) {
               val noteViewModel: NoteViewModel by viewModels()
               NotesApp(noteViewModel = noteViewModel)
            }
         }
      }
   }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel) {
   val noteList = noteViewModel.noteList.collectAsState().value

   NoteScreen(notes = noteList,
              onAddNotes = { noteViewModel.addNote(it) },
              onRemoveNote = { noteViewModel.removeNote(it) }
   )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
   NoteDemoComposeTheme {

   }
}