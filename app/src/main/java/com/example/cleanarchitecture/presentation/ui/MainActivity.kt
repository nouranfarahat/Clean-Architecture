package com.example.cleanarchitecture.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecture.di.AppContainer
import com.example.cleanarchitecture.MyApplication
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    //after using koin
    val phoneViewModel: PhoneViewModel by inject()
    // private lateinit var appContainer: AppContainer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        //appContainer = (application as MyApplication).appContainer

        lifecycleScope.launch {
            phoneViewModel.phoneBrand.collect {
                binding.brandTv.text = getString(it.brandName)
            }
        }


    }

}