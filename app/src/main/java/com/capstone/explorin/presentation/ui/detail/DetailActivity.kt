package com.capstone.explorin.presentation.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.capstone.explorin.R
import com.capstone.explorin.databinding.ActivityDetailBinding
import com.capstone.explorin.domain.model.Itinerary
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val viewModel: DetailViewModel by viewModels()

    private var itineraryId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        itineraryId = intent.getIntExtra("id", 0)

        setUpUI()
    }

    private fun setUpUI() {
        getData()
        provideData()
    }

    private fun provideData() {
        val toolbar: Toolbar = binding.toolbar

        lifecycleScope.launch {
            viewModel.state.collect { state ->
                Log.d("POIDetailActivity", state.toString())
                loadingStateIsToggled(state.isLoading)
                errorStateIsToggled(state.isError)

                binding.detailContent.root.visibility =
                    if (!state.isLoading && !state.isError) View.VISIBLE else View.GONE

                state.itinerary?.let { data ->
                    toolbar.title = data.name
                    setData(data)
                }
            }
        }
    }

    private fun getData() {
        itineraryId?.let { id ->
            viewModel.getDetailItinerary(id)
        }
    }

    private fun setData(data: Itinerary) {
        binding.detailContent.apply {
            Glide.with(ivItinerary)
                .load(data.image)
                .into(ivItinerary)

            itineraryName.text = data.name
            rating.text = data.rating.toString()
            tvDescription.text = data.description

        }

    }

    private fun loadingStateIsToggled(value: Boolean) {
        binding?.apply {
            stateLoading.root.visibility = if (value) View.VISIBLE else View.GONE
        }
    }

    private fun errorStateIsToggled(value: Boolean) {
        binding?.apply {
            stateError.root.visibility = if (value) View.VISIBLE else View.GONE
        }
    }
}