package com.satya.mealbox.repositories

import com.satya.mealbox.network.RetrofitService

class Repositories constructor(private val retrofitService: RetrofitService) {

    //for indian cuisine
    fun getAllIndianRecipes() = retrofitService.getAllIndianRecipes()


}