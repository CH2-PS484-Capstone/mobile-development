package com.capstone.explorin.presentation.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone.explorin.R
import com.capstone.explorin.databinding.ItemFavoriteBinding
import com.capstone.explorin.domain.model.Itinerary

class FavoriteAdapter: ListAdapter<Itinerary, FavoriteAdapter.ViewHolder>(FavoriteDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteAdapter.ViewHolder {
        val binding =
            ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteAdapter.ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
        holder.itemView.setOnClickListener {
            getItem(position)?.let { it1 -> onItemClickCallback.onItemClicked(it1) }
        }
    }

    inner class ViewHolder(private val binding: ItemFavoriteBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Itinerary) {
            binding.tvTitle.text = data.name
            binding.tvCategory.text = data.category.nameCategory
            binding.tvLocation.text = data.location

            Glide.with(itemView.context)
                .load(data.image)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(binding.ivPhoto)
        }
    }

    class FavoriteDiffCallback : DiffUtil.ItemCallback<Itinerary>() {
        override fun areItemsTheSame(oldItem: Itinerary, newItem: Itinerary): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Itinerary,
            newItem: Itinerary
        ): Boolean {
            return oldItem == newItem
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Itinerary)
    }
}