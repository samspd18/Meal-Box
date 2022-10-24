package com.satya.mealbox.model.indianRecipes


import com.google.gson.annotations.SerializedName

data class TopIndianRecipes(
    @SerializedName("number")
    val number: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("totalResults")
    val totalResults: Int
)