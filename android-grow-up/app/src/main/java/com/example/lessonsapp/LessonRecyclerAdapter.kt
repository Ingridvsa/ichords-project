package com.example.lessonsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LessonRecyclerAdapter(
    private val context: Context,
    private val lessons: List<LessonModel>,
    private val onClickListener: (LessonModel) -> Unit
) : RecyclerView.Adapter<LessonRecyclerAdapter.LessonViewHolder>() {

    override fun getItemCount(): Int = lessons.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.it_lesson_item, parent, false)
        return LessonViewHolder(view)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val lesson = lessons[position]
        holder.bind(lesson, onClickListener)
    }

    class LessonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val lessonTitle: TextView = view.findViewById(R.id.tvLessonTitle)
        val lessonDescription: TextView = view.findViewById(R.id.tvLessonDescription)

        fun bind(lesson: LessonModel, onClickListener: (LessonModel) -> Unit) {
            lessonTitle.text = lesson.title
            lessonDescription.text = lesson.description

            itemView.setOnClickListener {
                onClickListener(lesson)
            }
        }
    }
}

