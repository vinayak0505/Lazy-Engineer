package com.example.lazy_engineer.ui.main.file

import com.example.lazy_engineer.R

data class File(
    val id:Long,
    val title: Int,
    val image: Int,
    val subject: Int,
    val college: Int,
    val year: Int
)

val files = listOf(
    File(1,R.string.temp_file_title,R.drawable.image_book,R.string.temp_file_subject,R.string.temp_file_college,2020),
    File(2,R.string.temp_file_title,R.drawable.image_book,R.string.temp_file_subject,R.string.temp_file_college,2020),
    File(3,R.string.temp_file_title,R.drawable.image_book,R.string.temp_file_subject,R.string.temp_file_college,2020),
    File(4,R.string.temp_file_title,R.drawable.image_book,R.string.temp_file_subject,R.string.temp_file_college,2020),
    File(5,R.string.temp_file_title,R.drawable.image_book,R.string.temp_file_subject,R.string.temp_file_college,2020),
    File(6,R.string.temp_file_title,R.drawable.image_book,R.string.temp_file_subject,R.string.temp_file_college,2020),
    File(7,R.string.temp_file_title,R.drawable.image_book,R.string.temp_file_subject,R.string.temp_file_college,2020),
    File(8,R.string.temp_file_title,R.drawable.image_book,R.string.temp_file_subject,R.string.temp_file_college,2020),
)