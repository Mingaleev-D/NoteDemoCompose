package com.example.notedemocompose.model


import java.time.LocalDateTime
import java.time.LocalTime
import java.util.UUID

data class NoteModel(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val entryDate: LocalDateTime = LocalDateTime.now(),
)
