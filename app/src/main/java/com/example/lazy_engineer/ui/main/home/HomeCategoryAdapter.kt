package com.example.lazy_engineer.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lazy_engineer.databinding.ListItemHomeCategoriesBinding

class HomeCategoryAdapter(private val clickListener: HomeCategoryClickListener) :
    ListAdapter<HomeCategory, HomeCategoryAdapter.ViewHolder>(HomeCategoriesDiffCallBack()) {

    class ViewHolder private constructor(private val binding: ListItemHomeCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HomeCategory, clickListener: HomeCategoryClickListener) {
            binding.category = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemHomeCategoriesBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

}

class HomeCategoriesDiffCallBack : DiffUtil.ItemCallback<HomeCategory>() {
    override fun areItemsTheSame(oldItem: HomeCategory, newItem: HomeCategory): Boolean {
        return oldItem.homeCategoryType == newItem.homeCategoryType
    }

    override fun areContentsTheSame(oldItem: HomeCategory, newItem: HomeCategory): Boolean {
        return oldItem == newItem
    }

}

class HomeCategoryClickListener(val clickListener: (category: HomeCategory) -> Unit) {
    fun onClick(category: HomeCategory) = clickListener(category)
}