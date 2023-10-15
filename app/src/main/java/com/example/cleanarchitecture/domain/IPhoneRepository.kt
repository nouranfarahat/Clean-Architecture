package com.example.cleanarchitecture.domain

interface IPhoneRepository {
    suspend fun getPhoneData(): PhoneDomainModel

}