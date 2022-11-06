package com.satya.mealbox.network

import com.satya.mealbox.constant.Constants
import com.satya.mealbox.constant.Cuisine
import com.satya.mealbox.model.indianRecipes.TopIndianRecipes
import com.satya.mealbox.model.recipiesDetail.RecipiesDetailModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    //top indian recipes
    @GET("recipes/complexSearch?apiKey=${Constants.apiKey}&number=10&cuisine=Indian")
    fun getAllIndianRecipes(): Call<TopIndianRecipes>

    @GET("recipes/complexSearch?apiKey=${Constants.apiKey}&number=100")
    fun getAllCountrySpecificCuisines(@Query("cuisine") cuisine: String,@Query("diet") diet: String) : Call<TopIndianRecipes>

    @GET("recipes/{id}/information?apiKey=${Constants.apiKey}")
    fun getRecipesDetail(@Path("id")id: Int) : Call<RecipiesDetailModel>
}