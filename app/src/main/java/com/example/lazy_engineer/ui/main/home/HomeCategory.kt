package com.example.lazy_engineer.ui.main.home

import com.example.lazy_engineer.R

enum class HomeCategoryType{
    NOTES,
    QUESTION_PAPER,
    FILE,
    BOOKS,
    JOBS,
}

data class HomeCategory(
    val imageId:Int,
    val homeCategoryType: HomeCategoryType,
    val titleId:Int,
    val summaryId:Int
)

val listOfHomeCategories = listOf(
    HomeCategory(R.drawable.course_image,HomeCategoryType.NOTES,R.string.notes,R.string.notes_summary),
    HomeCategory(R.drawable.course_image,HomeCategoryType.QUESTION_PAPER,R.string.question_paper,R.string.notes_summary),
    HomeCategory(R.drawable.course_image,HomeCategoryType.FILE,R.string.file,R.string.notes_summary),
    HomeCategory(R.drawable.course_image,HomeCategoryType.BOOKS,R.string.books,R.string.notes_summary),
    HomeCategory(R.drawable.course_image,HomeCategoryType.JOBS,R.string.jobs,R.string.notes_summary),
)


