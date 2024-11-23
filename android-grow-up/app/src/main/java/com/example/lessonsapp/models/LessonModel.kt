package com.example.lessonsapp.models

data class LessonModel(
    val title: String,
    val description: String,
    val videoUrl: String?,
    val level: LessonLevel
)


