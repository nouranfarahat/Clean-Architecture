package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.data.datasource.RemoteDataSource
import com.example.cleanarchitecture.data.repo.PhoneRepositoryImp
import com.example.cleanarchitecture.domain.PhoneUseCase
import com.example.mvvm.allproducts.viewmodel.PhoneViewModelFactory

class AppContainer {

    private val remoteDataSource = RemoteDataSource()

    private val phoneRepository = PhoneRepositoryImp(remoteDataSource)
    private val phoneUseCase=PhoneUseCase(phoneRepository)
    val phoneViewModelFactory = PhoneViewModelFactory(phoneUseCase)

}