package com.example.lazy_engineer.ui.main.jobs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lazy_engineer.databinding.ListItemJobBinding

class JobsAdapter(private val clickListener: JobClickListener) : ListAdapter<Job, JobsAdapter.ViewHolder>(JobDiffCallBack()) {
    class ViewHolder(private val binding: ListItemJobBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Job,clickListener: JobClickListener) {
            binding.apply {
                job = item
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemJobBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position),clickListener)
    }
}

class JobDiffCallBack : DiffUtil.ItemCallback<Job>() {
    override fun areItemsTheSame(oldItem: Job, newItem: Job): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Job, newItem: Job): Boolean {
        return oldItem == newItem
    }

}

class JobClickListener(private val clickListener: (job: Job) -> Unit) {
    fun onClick(job: Job) = clickListener(job)
}