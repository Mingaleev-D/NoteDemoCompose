package com.example.notedemocompose.di

import android.content.Context
import androidx.room.Room
import com.example.notedemocompose.data.NoteDatabase
import com.example.notedemocompose.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

   @Singleton
   @Provides
   fun provideNoteDao(noteDatabase: NoteDatabase): NoteDatabaseDao {
      return noteDatabase.noteDao()
   }

   @Singleton
   @Provides
   fun provideAppDatabase(@ApplicationContext context: Context): NoteDatabase {
      return Room.databaseBuilder(context,
                                  NoteDatabase::class.java,
                                  "note_db"
      )
         .fallbackToDestructiveMigration()
         .build()
   }
}