package com.capstone.explorin.presentation.ui.view360

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.capstone.explorin.R
import com.capstone.explorin.databinding.ActivityView360Binding
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback
import com.google.android.gms.maps.StreetViewPanorama
import com.google.android.gms.maps.StreetViewPanoramaView
import com.google.android.gms.maps.model.LatLng


class View360Activity : AppCompatActivity(), OnStreetViewPanoramaReadyCallback {
    private lateinit var streetView: StreetViewPanoramaView
    private lateinit var binding: ActivityView360Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityView360Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        setUpUI(savedInstanceState)
    }

    private fun setUpUI(savedInstanceState: Bundle?) {
        val itineraryName = intent.getStringExtra("name")
        streetView = binding.detailContent.mapStreetView
        streetView.onCreate(savedInstanceState)
        streetView.getStreetViewPanoramaAsync(this)
        binding.detailContent.namaWisata.text = itineraryName
        binding.toolbar.title = itineraryName

    }

    override fun onStreetViewPanoramaReady(panorama: StreetViewPanorama) {
        val lat = intent.getDoubleExtra("lat", 0.0)
        val long = intent.getDoubleExtra("long", 0.0)
        Log.d("View360Activity", lat.toString())
        Log.d("View360Activity", long.toString())

        panorama.isStreetNamesEnabled = true
        panorama.isUserNavigationEnabled = true
        panorama.setPosition(LatLng(lat, long))

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
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        streetView.onResume()
    }

    override fun onPause() {
        super.onPause()
        streetView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        streetView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        streetView.onLowMemory()
    }
}