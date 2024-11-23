package com.example.lessonsapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LessonListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_list)

        val recyclerView: RecyclerView = findViewById(R.id.rvLessons)
        val category = intent.getStringExtra("category")

        val lessons = when (category) {
            "Básico" -> listOf(
                LessonModel("Lição 1", "Introdução ao Básico", "https://video_url.com", LessonLevel.BASIC),
                LessonModel("Lição 2", "Conceitos Iniciais", null, LessonLevel.BASIC)
            )
            "Intermediário" -> listOf(
                LessonModel("Lição 1", "Aprendizado Intermediário", "https://video_url.com", LessonLevel.INTERMEDIATE)
            )
            "Avançado" -> listOf(
                LessonModel("Lição 1", "Domínio Avançado", "https://video_url.com", LessonLevel.ADVANCED)
            )
            else -> emptyList()
        }

        val adapter = LessonRecyclerAdapter(this, lessons) { lesson ->
            Toast.makeText(this, "Clicou em: ${lesson.title}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
