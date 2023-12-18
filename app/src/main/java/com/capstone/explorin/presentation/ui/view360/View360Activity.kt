package com.capstone.explorin.presentation.ui.view360

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.capstone.explorin.R
import com.capstone.explorin.databinding.ActivityView360Binding
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback
import com.google.android.gms.maps.StreetViewPanorama
import com.google.android.gms.maps.StreetViewPanoramaView
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject

class View360Activity : AppCompatActivity(), OnStreetViewPanoramaReadyCallback {
    private lateinit var streetView: StreetViewPanoramaView
    private lateinit var binding: ActivityView360Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityView360Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        val itineraryId = intent.getIntExtra("id", 0)
        val itineraryName = intent.getStringExtra("name")
        streetView = binding.detailContent.mapStreetView
        streetView.onCreate(savedInstanceState)
        streetView.getStreetViewPanoramaAsync(this)
        binding.detailContent.namaWisata.text = itineraryName
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