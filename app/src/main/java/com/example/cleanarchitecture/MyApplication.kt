package com.example.cleanarchitecture

import android.app.Application
import appModuele
import com.example.cleanarchitecture.data.datasource.RemoteDataSource
import com.example.cleanarchitecture.data.repo.PhoneRepositoryImp
import com.example.cleanarchitecture.di.AppContainer
import com.example.cleanarchitecture.domain.IPhoneRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import viewModels

class MyApplication:Application() {

    //val appContainer = AppContainer()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(listOf( appModuele,viewModels))
        }


    }
}