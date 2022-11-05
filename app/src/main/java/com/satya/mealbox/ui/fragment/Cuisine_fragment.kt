package com.satya.mealbox.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.satya.mealbox.adapter.RegionCuisineAdapter
import com.satya.mealbox.databinding.FragmentCuisineFragmentBinding
import com.satya.mealbox.network.RetrofitInstance
import com.satya.mealbox.repositories.Repositories
import com.satya.mealbox.viewModel.ViewModel
import com.satya.mealbox.viewModel.ViewModelFactory

class Cuisine_fragment : Fragment() {

    private var _binding : FragmentCuisineFragmentBinding? = null
    private val binding get() = _binding!!
    private var recyclerViewItemCount: Int = 0
    var cuisineName : String = ""
    private lateinit var regionCuisineData: List<com.satya.mealbox.model.indianRecipes.Result>
    private lateinit var viewModel: ViewModel
    private val retrofitService = RetrofitInstance.getInstance()
    private var cuisineAdapter = RegionCuisineAdapter()
    private var dietType: String = "non-vegetarian"
    private var totalResultCount: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCuisineFragmentBinding.inflate(inflater, container, false)
        cuisineName = arguments?.getString("cuisine_name")!!.replace("\n"," ")

        val cuisine = cuisineName.split(" ")
        Log.e("name", cuisine[0] )

        binding.tvCuisines.text = cuisineName

        viewModel = ViewModelProvider(this, ViewModelFactory(Repositories(retrofitService)))[ViewModel::class.java]

        getCountrySpecificCuisine()

       // viewModel.getCountrySpecificCuisines()
        viewModel.getCountrySpecificCuisines(cuisine[0],dietType)


        binding.switchVeg.setOnClickListener {
            if(dietType == "non-vegetarian") {
                dietType = "vegetarian"
                binding.tvVegType.text = "($dietType)"
                viewModel.getCountrySpecificCuisines(cuisine[0],dietType)
            } else if(dietType == "vegetarian") {
                dietType = "non-vegetarian"
                binding.tvVegType.text = "($dietType)"
                viewModel.getCountrySpecificCuisines(cuisine[0],dietType)
            }
        }
        

        return binding.root
    }

    private fun getCountrySpecificCuisine() {
        binding.tvVegType.text = "($dietType)"
        binding.rvCuisine.adapter = cuisineAdapter
        viewModel.getCountrySpecificCuisines.observe(viewLifecycleOwner) {
            recyclerViewItemCount = 10
            regionCuisineData = it.results
            cuisineAdapter.setRegionCuisines(regionCuisineData,recyclerViewItemCount)
            totalResultCount = it.number.toString()
            "Showing result $recyclerViewItemCount of $totalResultCount".also { binding.tvCountText.text = it }
        }


        binding.tvPrev.setOnClickListener {
            if(recyclerViewItemCount > 10) {
                recyclerViewItemCount -= 10
                cuisineAdapter.setRegionCuisines(regionCuisineData,recyclerViewItemCount)
                "Showing result $recyclerViewItemCount of $totalResultCount".also { binding.tvCountText.text = it }
            } else {
                Toast.makeText(requireActivity(), "item count can't decrease below 10", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvNext.setOnClickListener {
            if(recyclerViewItemCount < 100) {
                if(totalResultCount.toInt() - recyclerViewItemCount > 10) {
                    recyclerViewItemCount += 10
                }
                cuisineAdapter.setRegionCuisines(regionCuisineData,recyclerViewItemCount)
                "Showing result $recyclerViewItemCount of $totalResultCount".also { binding.tvCountText.text = it }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}