package com.satya.mealbox.repositories

import com.satya.mealbox.network.RetrofitService

class Repositories constructor(private val retrofitService: RetrofitService) {

    //for indian cuisine
    fun getAllIndianRecipes() = retrofitService.getAllIndianRecipes()
    //for country specific cuisine
    fun getCountrySpecificCuisine(cuisine: String,diet: String) = retrofitService.getAllCountrySpecificCuisines(cuisine,diet)
    //recipes detail
    fun getRecipesDetail(id: Int) = retrofitService.getRecipesDetail(id)

}