package com.capstone.explorin.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone.explorin.R
import com.capstone.explorin.data.response.Itinerary
import com.capstone.explorin.databinding.ItemItineraryListBinding

class ItineraryAdapter: PagingDataAdapter<Itinerary, ItineraryAdapter.ViewHolder>(ItineraryDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItineraryAdapter.ViewHolder {
        val binding =
            ItemItineraryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItineraryAdapter.ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
        holder.itemView.setOnClickListener {
            getItem(position)?.let { it1 -> onItemClickCallback.onItemClicked(it1) }
        }
    }

    inner class ViewHolder(private val binding: ItemItineraryListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Itinerary) {
            binding.tvTitle.text = data.nameItinerary
            binding.tvCategory.text = data.category.toString()
            binding.tvLocation.text = data.city.toString()

            Glide.with(itemView.context)
                .load(data.photoItinerary)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(binding.ivPhoto)
        }
    }

    class ItineraryDiffCallback : DiffUtil.ItemCallback<Itinerary>() {
        override fun areItemsTheSame(oldItem: Itinerary, newItem: Itinerary): Boolean {
            return oldItem.idItinerary == newItem.idItinerary
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