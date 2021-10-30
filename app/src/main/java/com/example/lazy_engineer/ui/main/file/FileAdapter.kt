package com.example.lazy_engineer.ui.main.file

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lazy_engineer.databinding.ListItemFileBinding

class FileAdapter(private val clickListener: FileClickListener) :
    ListAdapter<File, FileAdapter.ViewHolder>(FileDiffCallBack()) {

    class ViewHolder(private val binding: ListItemFileBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: File, clickListener: FileClickListener) {
            binding.apply {
                file = item
                fileClickListener = clickListener
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemFileBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }
}

class FileDiffCallBack : DiffUtil.ItemCallback<File>() {
    override fun areItemsTheSame(oldItem: File, newItem: File): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: File, newItem: File): Boolean {
        return oldItem == newItem
    }
}

class FileClickListener(val clickListener: (file: File) -> Unit) {
    fun onClick(file: File) = clickListener(file)
}
