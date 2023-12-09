package com.capstone.explorin.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone.explorin.R
import com.capstone.explorin.databinding.ItemCityBinding
import com.capstone.explorin.domain.model.City

class CityAdapter: ListAdapter<City, CityAdapter.ViewHolder>(CitiesDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityAdapter.ViewHolder {
        val binding =
            ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityAdapter.ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
        holder.itemView.setOnClickListener {
            getItem(position)?.let { it1 -> onItemClickCallback.onItemClicked(it1) }
        }
    }

    inner class ViewHolder(private val binding: ItemCityBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: City) {

            binding.tvCity.text = data.nameCity

            Glide.with(itemView.context)
                .load(data.imgCity)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(binding.ivPhoto)
        }
    }

    class CitiesDiffCallback : DiffUtil.ItemCallback<City>() {
        override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem.idCity == newItem.idCity
        }

        override fun areContentsTheSame(
            oldItem: City,
            newItem: City
        ): Boolean {
            return oldItem == newItem
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: City)
    }
}