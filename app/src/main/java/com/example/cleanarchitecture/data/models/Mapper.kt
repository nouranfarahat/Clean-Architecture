package com.example.cleanarchitecture.data.models

import com.example.cleanarchitecture.domain.PhoneDomainModel

fun PhoneDataModel.toPhoneDomainModel():PhoneDomainModel = PhoneDomainModel(
        brandName=this.brandName?:""
    )
