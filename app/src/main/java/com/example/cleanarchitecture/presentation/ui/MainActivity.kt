package com.example.cleanarchitecture.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecture.data.datasource.RemoteDataSource
import com.example.cleanarchitecture.data.repo.PhoneRepositoryImp
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.domain.PhoneUseCase
import com.example.mvvm.allproducts.viewmodel.PhoneViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private lateinit var phoneViewModel: PhoneViewModel
    lateinit var phoneViewModelFactory: PhoneViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(LayoutInflater.from(this))
        //val viewModel by viewModels<PhoneViewModel>()
        setContentView(binding.root)


        viewModelInitialization()

        lifecycleScope.launch {
            phoneViewModel.phoneBrand.collect {
                binding.brandTv.text = getString(it.brandName)
            }
        }


    }

    fun viewModelInitialization()
    {
        phoneViewModelFactory = PhoneViewModelFactory(PhoneUseCase(PhoneRepositoryImp.getInstance(
            RemoteDataSource()
        )))
        phoneViewModel = ViewModelProvider(this,phoneViewModelFactory).get(PhoneViewModel::class.java)

    }
}