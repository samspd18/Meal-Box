package com.satya.mealbox.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satya.mealbox.model.indianRecipes.TopIndianRecipes
import com.satya.mealbox.repositories.Repositories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel (private val repository: Repositories) : ViewModel() {
    val indianRecipes = MutableLiveData<TopIndianRecipes>()
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
}