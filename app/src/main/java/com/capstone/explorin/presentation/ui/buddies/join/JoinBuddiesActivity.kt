package com.capstone.explorin.presentation.ui.buddies.join

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.explorin.R
import com.capstone.explorin.databinding.ActivityJoinBuddiesBinding

class JoinBuddiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJoinBuddiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBuddiesBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}