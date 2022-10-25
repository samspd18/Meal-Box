package com.satya.mealbox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.satya.mealbox.databinding.RecipesLayoutBinding
import com.satya.mealbox.model.indianRecipes.Result
import com.squareup.picasso.Picasso

class TopIndianRecipesAdapter: RecyclerView.Adapter<TopIndianRecipesAdapter.ViewHolder>() {
    private var recipes = mutableListOf<Result>()

    fun setRecipes(recipe: List<Result>) {
        this.recipes = recipe.toMutableList()
        notifyDataSetChanged()
    }

    class  ViewHolder(var binding: RecipesLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecipesLayoutBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipesData = recipes[position]
        holder.binding.tvBaseText.text = recipesData.title

        Picasso.get()
            .load(recipesData.image)
            .noFade()
            .into(holder.binding.ivBaseImage)
    }

    override fun getItemCount(): Int {
        return recipes.count()
    }


}