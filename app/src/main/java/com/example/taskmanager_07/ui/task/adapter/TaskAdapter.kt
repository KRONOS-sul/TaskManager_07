package com.example.taskmanager_07.ui.task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager_07.databinding.ItemTaskBinding
import com.example.taskmanager_07.model.Task

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val list = arrayListOf<Task>()

    fun addTask(task: Task) {
        list.add(0, task)
        notifyItemChanged(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.titleTv.text = task.title
            binding.contentTv.text = task.content
        }
    }
}
