package com.satya.mealbox.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.satya.mealbox.constant.Cuisine
import com.satya.mealbox.databinding.CuisineLayoutBinding
import com.satya.mealbox.databinding.SpecificCuisineLayoutBinding
import com.satya.mealbox.model.indianRecipes.Result
import com.squareup.picasso.Picasso

class RegionCuisineAdapter: RecyclerView.Adapter<RegionCuisineAdapter.ViewHolder>()  {

    private var regionCuisines = mutableListOf<Result>()
    private var recipeShowCount = 0

    fun setRegionCuisines(cuisine: List<Result>,count: Int) {
        this.regionCuisines = cuisine.toMutableList()
        this.recipeShowCount = count
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: SpecificCuisineLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        var cuisineName: String = ""
        var cuisineImage: String = ""
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SpecificCuisineLayoutBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cuisineData = regionCuisines[position]
        holder.binding.tvBaseText.text = cuisineData.title

        Picasso.get()
            .load(cuisineData.image)
            .noFade()
            .into(holder.binding.ivBaseImage)

        holder.cuisineName = cuisineData.title
        val bundle = Bundle()
        bundle.putString("cuisine_name",holder.cuisineName)
    }

    override fun getItemCount(): Int {
        return recipeShowCount
    }

}