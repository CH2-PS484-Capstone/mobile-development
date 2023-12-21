package com.capstone.explorin.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone.explorin.R
import com.capstone.explorin.databinding.ItemBuddiesListBinding
import com.capstone.explorin.domain.model.BuddiesList

class BuddiesAdapter: ListAdapter<BuddiesList, BuddiesAdapter.ViewHolder>(BuddiesDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BuddiesAdapter.ViewHolder {
        val binding =
            ItemBuddiesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuddiesAdapter.ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
        holder.itemView.setOnClickListener {
            getItem(position)?.let { it1 -> onItemClickCallback.onItemClicked(it1) }
        }
    }

    inner class ViewHolder(private val binding: ItemBuddiesListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: BuddiesList) {
            binding.tvTitle.text = data.itinerary.name
            binding.tvCategory.text = data.itinerary.category.nameCategory
            binding.tvLocation.text = data.itinerary.location
            binding.tvHead.text = data.buddiesTitle

            val peopleAdapter = PersonAdapter()
            peopleAdapter.submitList(data.people)
            binding.rvPeople.adapter = peopleAdapter

            Glide.with(itemView.context)
                .load(data.itinerary.image)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(binding.ivPhoto)
        }
    }

    class BuddiesDiffCallback : DiffUtil.ItemCallback<BuddiesList>() {
        override fun areItemsTheSame(oldItem: BuddiesList, newItem: BuddiesList): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: BuddiesList,
            newItem: BuddiesList
        ): Boolean {
            return oldItem == newItem
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: BuddiesList)
    }
}