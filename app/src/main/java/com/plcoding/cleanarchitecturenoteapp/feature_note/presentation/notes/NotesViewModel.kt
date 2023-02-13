package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    fun onEvent(event: NotesEvent){
        when(event){
            is NotesEvent.Order -> {

            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                }
            }
            is NotesEvent.RestoreNote -> {

            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isIsOrderSectionVisible = !state.value.isIsOrderSectionVisible
                )
            }
        }
    }
}