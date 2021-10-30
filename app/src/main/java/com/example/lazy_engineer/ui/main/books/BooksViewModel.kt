package com.example.lazy_engineer.ui.main.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BooksViewModel : ViewModel() {

    val listOfBooks = MutableLiveData(books)

    private val _navigateToBookDetailScreen = MutableLiveData<Long?>()
    val navigateToBookDetailScreen: LiveData<Long?>
        get() = _navigateToBookDetailScreen

    fun onBookClicked(bookId:Long){
        _navigateToBookDetailScreen.value = bookId
    }

    fun onNavigationToBookDetailScreenComplete(){
        _navigateToBookDetailScreen.value = null
    }
}