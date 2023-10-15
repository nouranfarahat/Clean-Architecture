package com.example.cleanarchitecture.data.datasource

import com.example.cleanarchitecture.data.models.PhoneDataModel

interface IDataSource
{
    fun getPhoneData():PhoneDataModel
}