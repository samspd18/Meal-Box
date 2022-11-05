package com.satya.mealbox.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.satya.mealbox.R
import com.satya.mealbox.constant.Cuisine
import com.satya.mealbox.databinding.CuisineLayoutBinding
import com.squareup.picasso.Picasso

class CuisineAdapter: RecyclerView.Adapter<CuisineAdapter.CuisineViewHolder>() {

    private var cuisines = mutableListOf<Cuisine>()

    fun setCuisines(cuisine: Array<Cuisine>) {
        this.cuisines = cuisine.toMutableList()
        notifyDataSetChanged()
    }

    class CuisineViewHolder(var binding: CuisineLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        var cuisineName: String = ""
        var cuisineImage: String = ""
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuisineViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CuisineLayoutBinding.inflate(inflater,parent,false)
        return CuisineViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CuisineViewHolder, position: Int) {
        val cuisineData = cuisines[position]
        holder.binding.tvCuisineName.text = cuisineData.name

        Picasso.get()
            .load(cuisineData.imageUrl)
            .noFade()
            .into(holder.binding.ivCuisineImage)

        holder.cuisineName = cuisineData.name
        val bundle = Bundle()
        bundle.putString("cuisine_name",holder.cuisineName)

        holder.binding.cvCuisine.setOnClickListener {
            val nav = holder.binding.root.findNavController()
            nav.navigate(R.id.nav_cuisines,bundle)
        }
    }

    override fun getItemCount(): Int {
        return cuisines.count()
    }

}