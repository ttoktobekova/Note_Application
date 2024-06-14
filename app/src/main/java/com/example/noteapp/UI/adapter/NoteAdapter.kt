package com.example.noteapp.UI.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.DATA.model.NoteModel
import com.example.noteapp.databinding.ItemNoteBinding

class NoteAdapter : ListAdapter<NoteModel, NoteAdapter.NoteViewHolder>(DIFF_CALLBACK()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: NoteModel) {
            binding.tvItemText.text = model.title
        }
    }


    class DIFF_CALLBACK : DiffUtil.ItemCallback<NoteModel>() {
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return newItem == oldItem
        }

        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.title == newItem.title
        }

    }
}

