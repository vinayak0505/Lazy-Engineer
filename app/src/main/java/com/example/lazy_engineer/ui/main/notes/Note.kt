package com.example.lazy_engineer.ui.main.notes

import com.example.lazy_engineer.R

data class Note(
    val id: Long,
    val image: Int,
    val title: Int,
    val summary: Int,
)

val notes = listOf(
    Note(1, R.drawable.document_image, R.string.document, R.string.document_summary),
    Note(2, R.drawable.document_image, R.string.document, R.string.document_summary),
    Note(3, R.drawable.document_image, R.string.document, R.string.document_summary),
    Note(4, R.drawable.document_image, R.string.document, R.string.document_summary),
    Note(5, R.drawable.document_image, R.string.document, R.string.document_summary),
)
