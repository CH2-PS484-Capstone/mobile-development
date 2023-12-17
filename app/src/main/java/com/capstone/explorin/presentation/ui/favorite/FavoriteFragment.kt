package com.capstone.explorin.presentation.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.capstone.explorin.databinding.FragmentFavoriteBinding
import com.capstone.explorin.domain.model.Itinerary
import com.capstone.explorin.presentation.adapter.FavoriteAdapter
import com.capstone.explorin.presentation.adapter.ItineraryAdapter
import kotlinx.coroutines.launch


class FavoriteFragment : Fragment() {

    private var _binding : FragmentFavoriteBinding? = null
    private val binding get() = _binding
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getFavorites()

        lifecycleScope.launch {
            viewModel.state.collect { state ->
                val stateData = state.itineraries.isEmpty()
                loadingStateIsToggled(stateData)
                errorStateIsToggled(state.isError)

                binding?.detailContent?.root?.visibility = if ((!stateData || state.isLoading) && !state.isError) View.VISIBLE else View.GONE

                setFavorites(state.itineraries)
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

    private fun setFavorites(popular: List<Itinerary>) {
        val adapter = FavoriteAdapter()
        adapter.submitList(popular)

        binding?.detailContent?.apply {
            rvFavorite.adapter = adapter
        }

    }


}