package com.satya.mealbox.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.satya.mealbox.R
import com.satya.mealbox.adapter.IngredientsAdapter
import com.satya.mealbox.adapter.InstructionAdapter
import com.satya.mealbox.databinding.FragmentCuisineFragmentBinding
import com.satya.mealbox.databinding.FragmentDetailRecipesBinding
import com.satya.mealbox.network.RetrofitInstance
import com.satya.mealbox.repositories.Repositories
import com.satya.mealbox.viewModel.ViewModel
import com.satya.mealbox.viewModel.ViewModelFactory
import com.squareup.picasso.Picasso

class DetailRecipesFragment : Fragment() {

    private var _binding : FragmentDetailRecipesBinding? = null
    private val binding get() = _binding!!
    private val retrofitService = RetrofitInstance.getInstance()
    private var ingredientsAdapter = IngredientsAdapter()
    private var instructionAdapter = InstructionAdapter()
    private lateinit var viewModel: ViewModel
    private var recipesId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailRecipesBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, ViewModelFactory(Repositories(retrofitService)))[ViewModel::class.java]

        recipesId = arguments?.getInt("recipesId")!!

        getRecipesDetail()

        //get RecipesDetail api call
        viewModel.getRecipesDetail(recipesId)
        return binding.root
    }

    private fun getRecipesDetail() {
        binding.rvInstructions.adapter = instructionAdapter
        binding.rvIngredients.adapter = ingredientsAdapter
        viewModel.getRecipesDetail.observe(viewLifecycleOwner) {
            instructionAdapter.setRecipesInstructions(it.analyzedInstructions[0].steps)
            ingredientsAdapter.setRecipesIngredients(it.extendedIngredients)
            Picasso.get()
                .load(it.image)
                .noFade()
                .into(binding.ivRecipesImage)
            binding.tvRecipesTitle.text = it.title
            "Servers - ${it.servings}".also { binding.tvRecipeServings.text = it }
            "${it.readyInMinutes} Mins".also { binding.tvRecipeTime.text = it }
            if(it.vegetarian) {
                binding.ivServingNonVeg.visibility = View.GONE
                binding.tvRecipeNonVeg.visibility = View.GONE
                binding.ivServingVegetarian.visibility = View.VISIBLE
                binding.tvRecipeVeg.visibility = View.VISIBLE
            } else {
                binding.ivServingNonVeg.visibility = View.VISIBLE
                binding.tvRecipeNonVeg.visibility = View.VISIBLE
                binding.ivServingVegetarian.visibility = View.GONE
                binding.tvRecipeVeg.visibility = View.GONE
            }
        }
    }
}