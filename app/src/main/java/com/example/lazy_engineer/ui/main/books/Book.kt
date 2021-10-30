package com.example.lazy_engineer.ui.main.books

import com.example.lazy_engineer.R

data class Book(
    val id: Long,
    val image: Int,
    val author: Int,
    val title: Int,
    val description: Int,
    val noOfPages: Int?,
)

val books = listOf(
    Book(1, R.drawable.image_book,R.string.temp_auther,R.string.temp_file_title,R.string.temp_book_desciption,200),
    Book(1, R.drawable.image_book,R.string.temp_auther,R.string.temp_file_title,R.string.temp_book_desciption,200),
    Book(1, R.drawable.image_book,R.string.temp_auther,R.string.temp_file_title,R.string.temp_book_desciption,200),
    Book(1, R.drawable.image_book,R.string.temp_auther,R.string.temp_file_title,R.string.temp_book_desciption,200),
    Book(1, R.drawable.image_book,R.string.temp_auther,R.string.temp_file_title,R.string.temp_book_desciption,200),
    Book(1, R.drawable.image_book,R.string.temp_auther,R.string.temp_file_title,R.string.temp_book_desciption,200),
    Book(1, R.drawable.image_book,R.string.temp_auther,R.string.temp_file_title,R.string.temp_book_desciption,200),
)