package com.capstone.explorin.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.capstone.explorin.R
import com.capstone.explorin.databinding.FragmentHomeBinding
import com.capstone.explorin.domain.model.Category
import com.capstone.explorin.domain.model.City
import com.capstone.explorin.domain.model.Itinerary
import com.capstone.explorin.presentation.adapter.CategoryAdapter
import com.capstone.explorin.presentation.adapter.CityAdapter
import com.capstone.explorin.presentation.adapter.ItineraryAdapter
import com.capstone.explorin.presentation.ui.auth.login.LoginActivity
import com.capstone.explorin.presentation.ui.detail.DetailActivity
import com.capstone.explorin.presentation.ui.detail.DetailFragment
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding
    private val viewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUI()
    }

    private fun setUpUI() {
        provideData()
    }

    private fun provideData() {
        viewModel.getCategories()
        viewModel.getPopular()
        viewModel.getCities()

        lifecycleScope.launch {
            viewModel.state.collect { state ->
                val stateData = state.categories.isEmpty() && state.recommendations.isEmpty() && state.city.isEmpty()
                loadingStateIsToggled(stateData)
                errorStateIsToggled(state.isError)

                binding?.detailContent?.root?.visibility = if ((!stateData || state.isLoading) && !state.isError) View.VISIBLE else View.GONE

                setCategories(state.categories)
                setRecommendations(state.recommendations)
                setCities(state.city)
            }
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

    private fun setCategories(categories: List<Category>) {
        val categoryAdapter = CategoryAdapter()
        categoryAdapter.submitList(categories)

        binding?.detailContent?.apply {
            rvCategory.adapter = categoryAdapter
        }

        categoryAdapter.setOnItemClickCallback(object : CategoryAdapter.OnItemClickCallback {
            override fun onItemClicked(name: String) {
                val intent = Intent(requireActivity(), LoginActivity::class.java).apply {
                    putExtra("category", name)
                }

                startActivity(intent)
            }
        })
    }

    private fun setRecommendations(popular: List<Itinerary>) {
        val recommendationAdapter = ItineraryAdapter()
        recommendationAdapter.submitList(popular)

        binding?.detailContent?.apply {
            rvItinerary.adapter = recommendationAdapter
        }

        recommendationAdapter.setOnItemClickCallback(object : ItineraryAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Itinerary) {
                val intent = Intent(requireActivity(), DetailActivity::class.java).apply {
                    putExtra("id", data.id)
                }

                startActivity(intent)
            }

        })



    }

    private fun setCities(cities: List<City>) {
        val adapter = CityAdapter()
        adapter.submitList(cities)

        binding?.detailContent?.apply {
            rvCity.adapter = adapter
        }

    }

}