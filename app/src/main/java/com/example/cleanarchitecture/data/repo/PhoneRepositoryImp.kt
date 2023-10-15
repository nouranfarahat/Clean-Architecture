package com.example.cleanarchitecture.data.repo

import android.util.Log
import com.example.cleanarchitecture.data.datasource.IDataSource
import com.example.cleanarchitecture.data.datasource.RemoteDataSource
import com.example.cleanarchitecture.data.models.toPhoneDomainModel
import com.example.cleanarchitecture.domain.IPhoneRepository
import com.example.cleanarchitecture.domain.PhoneDomainModel

class PhoneRepositoryImp(private  val dataSource: IDataSource):IPhoneRepository {

    companion object
    {
        private var instance: PhoneRepositoryImp?=null
        fun getInstance(
            remoteSource: RemoteDataSource
        ): PhoneRepositoryImp {
            return instance?: synchronized(this){
                val temp= PhoneRepositoryImp(remoteSource)
                instance=temp
                temp
            }
        }

    }

    override suspend fun getPhoneData(): PhoneDomainModel {
        return dataSource.getPhoneData().toPhoneDomainModel()
    }
}