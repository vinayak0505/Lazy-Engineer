package com.example.lazy_engineer.ui.main.jobs

import com.example.lazy_engineer.R

data class Job(
    val id: Long,
    val companyIcon: Int,
    val title: String,
    val company: String,
    val location: String,
    val noOfDaysFromPosted: Int,
    val bookMarked:Boolean = false
)

val jobs = listOf(
    Job(1, R.drawable.image_google,"Android Developer","Google","Gurugram, Haryana, India",10,true),
    Job(1, R.drawable.image_google,"Android Developer","Google","Gurugram, Haryana, India",10,true),
    Job(1, R.drawable.image_google,"Android Developer","Google","Gurugram, Haryana, India",10),
    Job(1, R.drawable.image_google,"Android Developer","Google","Gurugram, Haryana, India",10),
    Job(1, R.drawable.image_google,"Android Developer","Google","Gurugram, Haryana, India",10),
    Job(1, R.drawable.image_google,"Android Developer","Google","Gurugram, Haryana, India",10),
    Job(1, R.drawable.image_google,"Android Developer","Google","Gurugram, Haryana, India",10)
)
