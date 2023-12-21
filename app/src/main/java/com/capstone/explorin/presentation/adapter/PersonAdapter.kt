package com.capstone.explorin.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone.explorin.databinding.ItemPersonBinding
import com.capstone.explorin.domain.model.User

class PersonAdapter: ListAdapter<User, PersonAdapter.ViewHolder>(UserDiffCallback()) {
    inner class ViewHolder(private var binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User){
            Glide.with(itemView.context)
                .load(user.imgProfile)
                .into(binding.civProfile)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapter.ViewHolder {
        val binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonAdapter.ViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    private class UserDiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(name: String)
    }
}