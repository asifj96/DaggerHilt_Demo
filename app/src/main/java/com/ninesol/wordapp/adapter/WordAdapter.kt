package com.ninesol.wordapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ninesol.wordapp.databinding.ItemWordBinding
import com.ninesol.wordapp.model.Word


class WordAdapter(
    private val interaction: Interaction? = null,
) : ListAdapter<Word, WordAdapter.WordViewHolder>(WordDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WordViewHolder(
        ItemWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {

        holder.bindItems(getItem(position))
    }

    inner class WordViewHolder(private val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bindItems(item: Word) {
            binding.word = item
        }
    }

    interface Interaction
}

private class WordDC : DiffUtil.ItemCallback<Word>() {
    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem == newItem
    }
}

