package com.capstone.explorin.presentation.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.capstone.explorin.R
import com.capstone.explorin.databinding.ActivityDetailBinding
import com.capstone.explorin.domain.model.Category
import com.capstone.explorin.domain.model.Gallery
import com.capstone.explorin.domain.model.Itinerary
import com.capstone.explorin.presentation.adapter.CategoryAdapter
import com.capstone.explorin.presentation.adapter.GalleryAdapter
import com.capstone.explorin.presentation.ui.auth.login.LoginActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
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

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

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
                loadingStateIsToggled(state.isLoading)
                errorStateIsToggled(state.isError)

                binding.detailContent.root.visibility =
                    if (!state.isLoading && !state.isError) View.VISIBLE else View.GONE

                state.itinerary?.let { data ->
                    toolbar.title = data.name
                    setData(data)
                    data.gallery?.let { gallery -> setDataAdapter(gallery) }
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

            Glide.with(ivCategory)
                .load(data.category.iconCategory)
                .into(ivCategory)

            itineraryName.text = data.name
            rating.text = data.rating?.toString() ?: "Belum memiliki rating"
            tvDescription.text = data.description
            tvCity.text = data.location
            tvCategoryName.text = data.category.nameCategory

        }

    }

    private fun setDataAdapter(data : List<Gallery>) {
//        binding.detailContent.apply {
//            rvGallery.layoutManager = LinearLayoutManager(this@DetailActivity)
//
//            val adapter = GalleryAdapter(data)
//            adapter.setOnItemClickCallback(object : GuideAdapter.OnItemClickCallback {
//                override fun onItemClicked(guide: Guide) {
//                    showGuide(guide)
//                }
//            })
//        }

        val galleryAdapter = GalleryAdapter()
        galleryAdapter.submitList(data)

        binding.detailContent.apply {
            rvGallery.adapter = galleryAdapter
        }

//        galleryAdapter.setOnItemClickCallback(object : GalleryAdapter.OnItemClickCallback {
//            override fun onItemClicked(name: String) {
//                val intent = Intent(requireActivity(), LoginActivity::class.java).apply {
//                    putExtra("category", name)
//                }
//
//                startActivity(intent)
//            }
//        })

    }



    private fun loadingStateIsToggled(value: Boolean) {
        binding.apply {
            stateLoading.root.visibility = if (value) View.VISIBLE else View.GONE
        }
    }

    private fun errorStateIsToggled(value: Boolean) {
        binding.apply {
            stateError.root.visibility = if (value) View.VISIBLE else View.GONE
        }
    }
}