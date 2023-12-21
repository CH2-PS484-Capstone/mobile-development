package com.capstone.explorin.presentation.ui.buddies.detailbuddies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.capstone.explorin.R
import com.capstone.explorin.databinding.ActivityDetailBuddiesBinding
import com.capstone.explorin.domain.model.BuddiesList
import com.capstone.explorin.domain.model.User
import com.capstone.explorin.presentation.adapter.PeopleAdapter
import kotlinx.coroutines.launch

class DetailBuddiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBuddiesBinding
    private val viewModel: DetailBuddiesViewModel by viewModels()
    private var itineraryId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBuddiesBinding.inflate(layoutInflater)
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
        btnClicked()
    }

    private fun setData(data: BuddiesList) {
        binding.detailContent.apply {
            val firstPeople = data.people.firstOrNull()
            firstPeople?.let {
                Glide.with(civProfile)
                    .load(it.imgProfile)
                    .into(civProfile)

                tvProfile.text = it.username
            }

            buddiesTitle.text = data.buddiesTitle
            tvDescription.text = data.buddiesDescription

            Glide.with(itemItinerary.ivPhoto)
                .load(data.itinerary.image)
                .into(itemItinerary.ivPhoto)

            itemItinerary.tvTitle.text = data.itinerary.name
            itemItinerary.tvCategory.text = data.itinerary.category.nameCategory
            itemItinerary.tvLocation.text = data.itinerary.location
            itemItinerary.rating.text = data.itinerary.rating?.toString() ?: "0.0"


        }

    }

    private fun getData() {
        itineraryId?.let { id ->
            viewModel.getBuddies(id)
        }
    }

    private fun provideData() {
        val toolbar: Toolbar = binding.toolbar

        lifecycleScope.launch {
            viewModel.state.collect { state ->
                loadingStateIsToggled(state.isLoading)
                errorStateIsToggled(state.isError)

                binding.detailContent.root.visibility =
                    if (!state.isLoading && !state.isError) View.VISIBLE else View.GONE

                state.detail?.let { data ->
                    toolbar.title = data.buddiesTitle
                    setData(data)
                    setDataAdapter(data.people)
                }
            }
        }
    }

    private fun setDataAdapter(data: List<User>) {
        val userAdapter = PeopleAdapter()
        userAdapter.submitList(data)

        binding.detailContent.apply {
            rvPeople.adapter = userAdapter
        }
    }

    private fun btnClicked() {
        binding.detailContent.apply {

//            itemItinerary.item.setOnClickListener {
//                val intent = Intent(this@DetailBuddiesActivity, DetailActivity::class.java)
//                startActivity(intent)
//            }


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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}