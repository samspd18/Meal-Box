package com.satya.mealbox.ui.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.satya.mealbox.adapter.CuisineAdapter
import com.satya.mealbox.constant.Constants
import com.satya.mealbox.constant.Constants.Companion.sharedPrefFile
import com.satya.mealbox.constant.Cuisine
import com.satya.mealbox.constant.DifferentCuisine
import com.satya.mealbox.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val adapter = CuisineAdapter()
    lateinit var cuisines: Array<Cuisine>

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

        //binding the cuisine recycler view
        cuisineRecyclerView()

        return root
    }
    private fun cuisineRecyclerView() {
        binding.rvCuisine.adapter = adapter
        cuisines = DifferentCuisine.cuisines
        adapter.setCuisines(cuisines)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}