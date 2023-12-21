package com.capstone.explorin.presentation.ui.buddies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.capstone.explorin.databinding.ActivityBuddiesBinding
import com.capstone.explorin.domain.model.BuddiesList
import com.capstone.explorin.presentation.adapter.BuddiesAdapter
import com.capstone.explorin.presentation.ui.buddies.detailbuddies.DetailBuddiesActivity
import kotlinx.coroutines.launch

class BuddiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBuddiesBinding
    private val viewModel: BuddiesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuddiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()
    }

    private fun setUpUI() {
        provideData()
    }

    private fun provideData() {
        viewModel.getBuddies()

        lifecycleScope.launch {
            viewModel.state.collect { state ->
                val stateData =
                    state.buddies.isEmpty()
                loadingStateIsToggled(stateData)
                errorStateIsToggled(state.isError)

                binding.detailContent.root.visibility =
                    if ((!stateData || state.isLoading) && !state.isError) View.VISIBLE else View.GONE

                setBuddies(state.buddies)
            }
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

    private fun setBuddies(buddies: List<BuddiesList>) {
        val buddiesAdapter = BuddiesAdapter()
        buddiesAdapter.submitList(buddies)

        binding.detailContent.apply {
            rvBuddies.adapter = buddiesAdapter
        }

        buddiesAdapter.setOnItemClickCallback(object : BuddiesAdapter.OnItemClickCallback {
            override fun onItemClicked(data: BuddiesList) {
                val intent = Intent(this@BuddiesActivity, DetailBuddiesActivity::class.java).apply {
                    putExtra("id", data.id)
                }
                startActivity(intent)
            }

        })
    }
}