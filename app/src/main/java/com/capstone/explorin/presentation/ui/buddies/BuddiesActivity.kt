package com.capstone.explorin.presentation.ui.buddies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.capstone.explorin.R
import com.capstone.explorin.databinding.ActivityBuddiesBinding

class BuddiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBuddiesBinding
    private val viewModel: BuddiesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buddies)
    }
}