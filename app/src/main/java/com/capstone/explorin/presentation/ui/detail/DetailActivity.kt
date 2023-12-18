package com.capstone.explorin.presentation.ui.detail

import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
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
import com.capstone.explorin.presentation.ui.view360.View360Activity
import com.capstone.explorin.presentation.utils.LocationConverter
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var mMap: GoogleMap
    private val boundBuilder = LatLngBounds.Builder()
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

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        setUpUI()
    }

    private fun setUpUI() {
        getData()
        provideData()
        btnClicked()
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
                    // Set marker when the itinerary data is available
                    if (::mMap.isInitialized) {
                        setMarker(data)
                    }

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

    private fun btnClicked() {
        binding.detailContent.btn360.setOnClickListener {
            val data = viewModel.state.value.itinerary
            data?.let {
                val intent = Intent(this@DetailActivity, View360Activity::class.java)
                intent.putExtra("id", it.id)
                intent.putExtra("name", it.name)
                intent.putExtra("lat", it.position.lat)
                intent.putExtra("long", it.position.long)
                startActivity(intent)
            }
        }

    }

    private fun setDataAdapter(data : List<Gallery>) {
        val galleryAdapter = GalleryAdapter()
        galleryAdapter.submitList(data)

        binding.detailContent.apply {
            rvGallery.adapter = galleryAdapter
        }
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

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        provideData()
    }

    private fun setMarker(data: Itinerary) {
        lateinit var locationZoom: LatLng
        if (data.position.lat != null && data.position.long != null) {
            val latLng = LatLng(data.position.lat, data.position.long)
            val address = LocationConverter.getStringAddress(latLng, this)
            val marker = mMap.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title(data.name)
                    .snippet(address)
            )
            boundBuilder.include(latLng)
            marker?.tag = data

            locationZoom = latLng
        }


        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                locationZoom, 3f
            )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.favorite -> {
                TODO()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getLocation() {
        if (checkPermission(Manifest.permission.ACCESS_FINE_LOCATION) &&
            checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
        ) {

        }
    }

    private fun checkPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }
}