package com.example.lessonsapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class LessonCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_category)

        val categories = listOf("Básico", "Intermediário", "Avançado")
        val listView: ListView = findViewById(R.id.lvLessonCategories)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, categories)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val category = categories[position]
            val intent = Intent(this, LessonListActivity::class.java)
            intent.putExtra("category", category)
            startActivity(intent)
        }
    }
}
