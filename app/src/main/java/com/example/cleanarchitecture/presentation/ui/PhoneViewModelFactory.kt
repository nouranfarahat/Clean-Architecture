package com.example.mvvm.allproducts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.domain.PhoneUseCase
import com.example.cleanarchitecture.presentation.ui.PhoneViewModel

class PhoneViewModelFactory(private val phoneUseCase: PhoneUseCase):
    ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(PhoneViewModel::class.java))
        {
            PhoneViewModel(phoneUseCase) as T
        }
        else
        {
            throw IllegalStateException("ViewModel Class not found")
        }
    }
}