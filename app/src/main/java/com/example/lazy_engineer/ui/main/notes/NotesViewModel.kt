package com.example.lazy_engineer.ui.main.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotesViewModel : ViewModel() {
    val listOfNotes = MutableLiveData(notes)
}