package com.satya.mealbox.network

import com.satya.mealbox.constant.Constants
import com.satya.mealbox.model.indianRecipes.TopIndianRecipes
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    //top indian recipes
    @GET("complexSearch?apiKey=${Constants.apiKey}&number=10&cuisine=Indian")
    fun getAllIndianRecipes(): Call<TopIndianRecipes>
}