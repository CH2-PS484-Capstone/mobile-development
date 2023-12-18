package com.capstone.explorin.presentation.ui.buddies.detailbuddies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.capstone.explorin.databinding.ActivityDetailBuddiesBinding
import com.capstone.explorin.presentation.ui.buddies.BuddiesViewModel

class DetailBuddiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBuddiesBinding
    private val viewModel: BuddiesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBuddiesBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}