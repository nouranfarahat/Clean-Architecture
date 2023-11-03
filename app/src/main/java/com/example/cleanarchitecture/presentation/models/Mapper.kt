package com.example.cleanarchitecture.presentation.models

import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.data.models.PhoneBrandEnum
import com.example.cleanarchitecture.domain.PhoneDomainModel

fun PhoneDomainModel.toPhoneUIModel(): PhoneUIModel = PhoneUIModel(
    brandName= when(this.brandName)
    {
        PhoneBrandEnum.IPHONE.phoneBrand -> R.string.iphone
        PhoneBrandEnum.SAMSUNG.phoneBrand -> R.string.samsung

        else -> throw IllegalArgumentException("Unknown phone brand: ${this.brandName}")

        //old solution
        /*"I" -> PhoneBrandEnum.IPHONE.name
        "S" -> PhoneBrandEnum.SAMSUNG.name

        else -> PhoneBrandEnum.UNKNOWN.name*/
    }
)