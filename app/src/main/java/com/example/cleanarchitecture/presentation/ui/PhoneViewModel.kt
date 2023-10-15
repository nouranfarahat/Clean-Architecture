package com.example.cleanarchitecture.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.data.models.PhoneBrandEnum
import com.example.cleanarchitecture.domain.PhoneUseCase
import com.example.cleanarchitecture.presentation.models.PhoneUIModel
import com.example.cleanarchitecture.presentation.models.toPhoneUIModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PhoneViewModel(private val phoneUseCase:PhoneUseCase):ViewModel() {

    private val _phoneBrand: MutableStateFlow<PhoneUIModel> = MutableStateFlow(PhoneUIModel(0))
    val phoneBrand: StateFlow<PhoneUIModel>
        get() = _phoneBrand

    init {
        getPhoneBrand()
    }

   private fun getPhoneBrand()=viewModelScope.launch{
        _phoneBrand.value=phoneUseCase.getDataFromRepo().toPhoneUIModel()
    }
}