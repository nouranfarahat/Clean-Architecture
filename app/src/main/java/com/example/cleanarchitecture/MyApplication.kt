package com.example.cleanarchitecture

import android.app.Application
import com.example.cleanarchitecture.di.AppContainer

class MyApplication:Application() {

    val appContainer = AppContainer()
}