package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases

data class NoteUseCases(
    val getNotes: GetNotesUseCase,
    val deleteNote: DeleteNoteUseCase
)