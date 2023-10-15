package com.example.cleanarchitecture.domain

class PhoneUseCase(private val phoneRepo: IPhoneRepository) {

    suspend fun getDataFromRepo(): PhoneDomainModel = phoneRepo.getPhoneData()
}