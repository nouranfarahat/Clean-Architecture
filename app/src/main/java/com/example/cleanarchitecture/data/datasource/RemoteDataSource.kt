package com.example.cleanarchitecture.data.datasource

import com.example.cleanarchitecture.data.models.PhoneDataModel
import java.util.Date

class RemoteDataSource : IDataSource {
    override fun getPhoneData(): PhoneDataModel {
        return PhoneDataModel(
                "I",
                "Iphone 15 pro",
                123,
                Date(2))
    }


}