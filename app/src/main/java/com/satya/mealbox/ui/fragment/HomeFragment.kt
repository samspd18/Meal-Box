package com.satya.mealbox.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.satya.mealbox.adapter.CuisineAdapter
import com.satya.mealbox.adapter.EatsWhatMakesYouHappyAdapter
import com.satya.mealbox.adapter.TopIndianRecipesAdapter
import com.satya.mealbox.constant.Cuisine
import com.satya.mealbox.constant.DifferentCuisine
import com.satya.mealbox.constant.DifferentFoodItem
import com.satya.mealbox.constant.MakesYouHappy
import com.satya.mealbox.databinding.FragmentHomeBinding
import com.satya.mealbox.network.RetrofitInstance
import com.satya.mealbox.repositories.Repositories
import com.satya.mealbox.viewModel.ViewModel
import com.satya.mealbox.viewModel.ViewModelFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter = CuisineAdapter()
    private lateinit var cuisines: Array<Cuisine>
    private lateinit var eatWahtMakesYouHappy: Array<MakesYouHappy>

    //declare the api call
    private lateinit var viewModel: ViewModel
    private val retrofitService = RetrofitInstance.getInstance()

    private var topIndianRecipesAdapter = TopIndianRecipesAdapter()
    private var whatMakesYouHappyAdapter = EatsWhatMakesYouHappyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
                activity?.finishAffinity()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel = ViewModelProvider(this, ViewModelFactory(Repositories(retrofitService)))[ViewModel::class.java]

        getAllTopIndianRecipes()

        viewModel.getTopIndianRecipes()

        //binding the cuisine recycler view
        cuisineRecyclerView()
        //binding what makes you happy recyclerview
        whatMakesYouHappy()

        return root
    }

    private fun getAllTopIndianRecipes() {
        binding.rvIndianRecipes.adapter = topIndianRecipesAdapter
        viewModel.indianRecipes.observe(viewLifecycleOwner) {
            topIndianRecipesAdapter.setRecipes(it.results)
        }
    }

    private fun cuisineRecyclerView() {
        binding.rvCuisine.adapter = adapter
        cuisines = DifferentCuisine.cuisines
        adapter.setCuisines(cuisines)
    }

    private fun whatMakesYouHappy() {
        binding.rvWhatMakesYouHappy.adapter = whatMakesYouHappyAdapter
        eatWahtMakesYouHappy = DifferentFoodItem.differentFood
        whatMakesYouHappyAdapter.setFoodItems(eatWahtMakesYouHappy)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}