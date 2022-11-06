package com.satya.mealbox.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satya.mealbox.model.indianRecipes.TopIndianRecipes
import com.satya.mealbox.model.recipiesDetail.RecipiesDetailModel
import com.satya.mealbox.repositories.Repositories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel (private val repository: Repositories) : ViewModel() {
    val indianRecipes = MutableLiveData<TopIndianRecipes>()
    val getCountrySpecificCuisines = MutableLiveData<TopIndianRecipes>()
    val getRecipesDetail = MutableLiveData<RecipiesDetailModel>()
    val errorMessage = MutableLiveData<String>()

    fun getTopIndianRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAllIndianRecipes()
            response.enqueue(object : Callback<TopIndianRecipes> {
                override fun onResponse(call: Call<TopIndianRecipes>, response: Response<TopIndianRecipes>) {
                    indianRecipes.postValue(response.body())
                }
                override fun onFailure(call: Call<TopIndianRecipes>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            })
        }
    }

    // As the model of top indian recipes and cuisine response are same
    // So use the same model
    fun getCountrySpecificCuisines(cuisineType: String,diet : String) {
        viewModelScope.launch (Dispatchers.IO) {
            val response = repository.getCountrySpecificCuisine(cuisineType,diet)
            response.enqueue(object : Callback<TopIndianRecipes> {
                override fun onResponse(call: Call<TopIndianRecipes>, response: Response<TopIndianRecipes>) {
                    getCountrySpecificCuisines.postValue(response.body())
                }
                override fun onFailure(call: Call<TopIndianRecipes>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            })
        }
    }

    //recipes Detail model
    fun getRecipesDetail(id: Int) {
        viewModelScope.launch (Dispatchers.IO) {
            val response = repository.getRecipesDetail(id)
            response.enqueue(object : Callback<RecipiesDetailModel> {
                override fun onResponse(call: Call<RecipiesDetailModel>, response: Response<RecipiesDetailModel>) {
                    getRecipesDetail.postValue(response.body())
                }
                override fun onFailure(call: Call<RecipiesDetailModel>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            })
        }
    }
}