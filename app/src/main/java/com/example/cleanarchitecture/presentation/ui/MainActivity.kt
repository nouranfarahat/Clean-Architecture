package com.example.cleanarchitecture.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecture.di.AppContainer
import com.example.cleanarchitecture.MyApplication
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private lateinit var phoneViewModel: PhoneViewModel
    //lateinit var phoneViewModelFactory: PhoneViewModelFactory
    private lateinit var appContainer: AppContainer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(LayoutInflater.from(this))
        //val viewModel by viewModels<PhoneViewModel>()
        setContentView(binding.root)

        appContainer = (application as MyApplication).appContainer


        viewModelInitialization()

        lifecycleScope.launch {
            phoneViewModel.phoneBrand.collect {
                binding.brandTv.text = getString(it.brandName)
            }
        }


    }

    fun viewModelInitialization()
    {
//        phoneViewModelFactory = PhoneViewModelFactory(PhoneUseCase(PhoneRepositoryImp.getInstance(
//            RemoteDataSource()
//        )))
        //phoneViewModel = ViewModelProvider(this,phoneViewModelFactory).get(PhoneViewModel::class.java)
        phoneViewModel=appContainer.phoneViewModelFactory.create(PhoneViewModel::class.java)

    }
}