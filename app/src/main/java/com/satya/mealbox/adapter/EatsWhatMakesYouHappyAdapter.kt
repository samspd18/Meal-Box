package com.satya.mealbox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.satya.mealbox.constant.MakesYouHappy
import com.satya.mealbox.databinding.DifferentFoodItemLayoutBinding
import com.squareup.picasso.Picasso

class EatsWhatMakesYouHappyAdapter : RecyclerView.Adapter<EatsWhatMakesYouHappyAdapter.ViewHolder>() {

    private var foodItems = mutableListOf<MakesYouHappy>()

    fun setFoodItems(food: Array<MakesYouHappy>) {
        this.foodItems = food.toMutableList()
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: DifferentFoodItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        var cuisineName: String = ""
        var cuisineImage: String = ""
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DifferentFoodItemLayoutBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodItemData = foodItems[position]
        holder.binding.tvDifferentFoodName.text = foodItemData.name

        Picasso.get()
            .load(foodItemData.imageUrl)
            .noFade()
            .into(holder.binding.ivDifferentFoodImage)
    }

    override fun getItemCount(): Int {
        return foodItems.count()
    }

}