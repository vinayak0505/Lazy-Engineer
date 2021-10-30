package com.example.lazy_engineer.ui.main.books

import android.icu.text.UnicodeSetIterator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lazy_engineer.databinding.ListItemBookBinding

class BookAdapter(private val clickListener: BookClickListener) : ListAdapter<Book, BookAdapter.ViewHolder>(BookDiffCallBack()) {

    class ViewHolder(private val binding: ListItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Book,clickListener: BookClickListener) {
            binding.apply {
                book = item
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemBookBinding.inflate(layoutInflater, parent, false)
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

class BookDiffCallBack : DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem == newItem
    }

}

class BookClickListener(private val clickListener: (item: Book) -> Unit) {
    fun onClick(book: Book) = clickListener(book)
}