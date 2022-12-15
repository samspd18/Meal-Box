package com.satya.mealbox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.satya.mealbox.constant.Constants.Companion.ingredientsImageUrl
import com.satya.mealbox.databinding.IngredientsLayoutBinding
import com.satya.mealbox.model.recipiesDetail.ExtendedIngredient
import com.squareup.picasso.Picasso

class IngredientsAdapter : RecyclerView.Adapter<IngredientsAdapter.ViewHolder>()  {

    private var recipesIngredients = mutableListOf<ExtendedIngredient>()

    fun setRecipesIngredients(cuisineIngredients: List<ExtendedIngredient>) {
        this.recipesIngredients = cuisineIngredients.toMutableList()
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: IngredientsLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = IngredientsLayoutBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipesIngredientData = recipesIngredients[position]
        holder.binding.tvIngredientName.text = recipesIngredientData.originalName
        holder.binding.tvIngredientAmount.text = recipesIngredientData.original

        Picasso.get()
            .load(ingredientsImageUrl+recipesIngredientData.image)
            .resize(110, 110)
            .noFade()
            .into(holder.binding.ivIngredientImage)

    }

    override fun getItemCount(): Int {
        return recipesIngredients.count()
    }
}