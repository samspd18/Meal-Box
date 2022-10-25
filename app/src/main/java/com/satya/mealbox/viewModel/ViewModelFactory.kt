package com.satya.mealbox.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.satya.mealbox.repositories.Repositories


class ViewModelFactory constructor(private val repository: Repositories) :  ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(com.satya.mealbox.viewModel.ViewModel::class.java)) {
            ViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}